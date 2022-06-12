import threading
import time
import random

class Barberia(threading.Thread):
    '''
    nSillas = Sillas Maximas para la espera de clientes , si se supera se van
    nmasterChair = Silla Ocupada , por el cliente , estado de que si se esta cortando
                   a un cliente
    colaClientes = cola para almacenar en orden a los clientes que llegan
    '''
    def __init__(self,numeroSillas):
        threading.Thread.__init__(self, name='Barberia', target=Barberia.run)
        self._nSillas=numeroSillas
        self._masterChair=False
        self._colaClientes=[]

    '''
    Metodo para cortar el pelo de un cliente,
    Su ejecucion permite quitar a un cliente de la cola
    '''
    def cortarPelo(self):
        try:
            pass
            self._masterChair=True #OCUPAMOS SILLA
            print('-> BARBERO CORTANDO PELO A CLIENTE',end='\n')
            time.sleep(random.randint(1, 5)) # SIMULACION DE TIEMPO PARA CORTAR
            print('-> BARBERO TERMINO DE CORTAR PELO',end='\n')
            if len(self._colaClientes)!=0:
                self._colaClientes.pop()
            self._masterChair = False

        except Exception as e:
            print(f'Excepcion: {e}')

    '''
    Metodo para agregar cliente a la cola
    , hace la validacion si nSillas = Maximo valor ,
    el cliente no se agrega a la cola y se va
    '''
    def agregarClienteCola(self,cliente):
        if (self._nSillas==len(self._colaClientes)):
            print('Llego un Cliente , esta lleno -> Se va')
            return False
        else:
            self._colaClientes.append(cliente)
            return True

    @property
    def numeroClientes(self):
        return len(self._colaClientes)

    @property
    def masterChair(self): #ESTADO DE OCUPACION DE LA SILLA
        return self._masterChair

    @masterChair.setter
    def masterChair(self,set): # CAMBIAR ESTADO DE OCUPACION DE LA SILLA
        self._masterChair=set

    '''
    Ejecucion de este Hilo , siempre estar activo para hacer las validaciones
    '''
    def run(self) -> None:
        while(True):
            pass