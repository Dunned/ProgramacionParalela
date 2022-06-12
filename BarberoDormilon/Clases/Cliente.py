import threading
import time

from Clases.Barbero import Barbero
from Clases.Barberia import Barberia


class Cliente(threading.Thread):

    '''
       Objeto Barbero ,
       Barberia : Objeto para hacer las validaciones y control
       Condition : Para el paso de informacion con notify y wait entre hilos
       name : nombre del Cliente
   '''
    def __init__(self, barberia:Barberia, barbero:Barbero,
                 condition:threading.Condition, name):
        threading.Thread.__init__(self,name=name,target=Cliente.run)
        self._barbero=barbero
        self._barberia=barberia
        self._condition=condition
        if barberia.agregarClienteCola(self): # ANTES DE AGREGAR CLIENTE VERIFICAMOS SI HAY CUPOS
            print(f'\tBIENVENIDO NUEVO CLIENTE : {self.getName()}')
            print(f'ESTAS #{self._barberia.numeroClientes}  EN LA COLA', end='\n')
            time.sleep(1)
        else:
            del self # SI NO HAY CUPOS DESTRUIMOS EL OBJETO

    '''
    Metodo run del hilo , despertara y emitira senal para que el barbero pueda empezar a cortar pelo
    '''
    def run(self) -> None:
        #HAY QUE DESPERTAR AL CLIENTE SI ES QUE ESTA DORMIDO
        if self._barbero.estaDormido==True:
            self.despertar()
        while(True):
            #SE SUELTE LA SILLA DEL BARBERO, SE OCUPE
            if self._barberia.masterChair==False:
                self._barberia.cortarPelo()
                break

    '''
    Metodo para emitir señal y despertar al barbero
    '''
    def despertar(self):
        with self._condition:
            self._condition.notify()


