import threading
import time

from Clases.Barberia import Barberia


class Barbero(threading.Thread):

    '''
    Objeto Barbero ,
    Barberia : Objeto para hacer las validaciones y control
    Condition : Para el paso de informacion con notify y wait entre hilos
    name : nombre del Barbero
    duerme : estado del barbero (duerme o despierto)
    '''
    def __init__(self, barberia:Barberia, condition:threading.Condition, name):
        threading.Thread.__init__(self,name=name,target=Barbero.run)
        self._duerme=False
        self._barberia=barberia
        self._condition=condition


    @property
    def estaDormido(self):
        return self._duerme

    '''
    Metodo para dormir a un barbero si no hay clientes
    '''
    def dormir(self):
        try:
            print(f'*** NO HAY CLIENTE EL {self.name} SE PONE A DORMIR ***',end='\n')
            self._duerme=True
            self._barberia.masterChair=True
            with self._condition:
                self._condition.wait() #ESPERA
            print(f'*** UN CLIENTE LLEGO Y  DESPERTO AL BARBERO {self.name} ***',end='\n')

            self._duerme=False # DESPERTAMOS AL BARBERO
            self._barberia.masterChair=False # DESOCUPAMOS LA SILLA

        except Exception as e:
            print(f'Ocurrio una excepcion: {e}')

    '''
    Metodo Ruun del Hilo , dormira al Barbero en caso no existe clientes esperando
    '''
    def run(self) -> None:
        #EL BARBERO NECESITA REVISAR SI HAY MAS CLIENTES EN ESPERA
        # SI NO HAY SE SIENTA A DORMIR
        while(True):
            time.sleep(0.1)
            if ((self._duerme==False) and (self._barberia.masterChair == False)
                    and (self._barberia.numeroClientes == 0)):
                self.dormir()

