import threading
import time
import random

class Barberia(threading.Thread):

    TARIFACORTE=50 # TARIFA POR CORTE
    '''
    nSillas = Sillas Maximas para la espera de clientes , si se supera se van
    nmasterChair = Silla Ocupada , por el cliente , estado de que si se esta cortando
                   a un cliente
    colaClientes = cola para almacenar en orden a los clientes que llegan
    dineroGanado: Guarda las ganancias por el servicio
    '''
    def __init__(self,numeroSillas):
        threading.Thread.__init__(self, name='Barberia', target=Barberia.run)
        self._nSillas=numeroSillas
        self._masterChair=False
        self._colaClientes=[]
        self._dineroGanado=0

    '''
    Metodo para cortar el pelo de un cliente,
    Su ejecucion permite quitar a un cliente de la cola
    '''
    def cortarPelo(self):
        try:
            self._masterChair=True #OCUPAMOS SILLA
            clienteP = self._colaClientes.pop()
            print(f'-> BARBERO CORTANDO PELO A CLIENTE {clienteP.name}'
                  ' \u2702\uFE0F \u2702\uFE0F \u2702\uFE0F \u2702\uFE0F',end='\n')
            time.sleep(5) # SIMULACION DE TIEMPO PARA CORTAR
            print(f'-> BARBERO TERMINO DE CORTAR PELO {clienteP.name}'
                  f' \U0001f487 \U0001f487 \U0001f487',end='\n')
            self._dineroGanado=self._dineroGanado+self.TARIFACORTE
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
            print(f'\nLlego el cliente {cliente.name} , esta lleno -> Se va')
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