import random
import threading
import time

from Clases.Barbero import Barbero
from Clases.Cliente import Cliente
from Clases.Barberia import Barberia

if __name__=='__main__':

    numero_sillas=10 # NUMERO DE SILLAS MAXIMAS PARA EL LOCAL DE LA BARBERIA
    condition = threading.Condition() #OBJETO ENCARGADO DE COMUNICAR HILSO MEDIANTE NOTIFY AND WAIT
    barberia=Barberia(numeroSillas=numero_sillas) #CREAMOS LA BARBERIA
    barbero=Barbero(barberia=barberia, condition=condition, name='BARBERO 1') #CREAMOS UN BARBERO
    barbero.start() #INICIAMOS HILO DEL BARBERO
    barberia.start() # INICIAMOS HILO DE LA BARBERIA
    numero_clientes=[1,2,3] # CREAMOS 3 SUPUESTOS CLIENTES

    for n in numero_clientes:
        time.sleep(random.randint(1,3)) # CREAMOS OBJETOS CLIENTES (HILOS) PARA MANDAR A LA BARBERIA Y SER ATENDIDOS
        c=Cliente(barberia=barberia, condition=condition, barbero=barbero, name=n)
        c.start()

    time.sleep(20) # ESPERAMOS QUE PASEN 20 SEGUNDOS , EL BARBERO DEBERIA ESTAR DORMIDO Y DEBERIA DESPERTARSE
    c = Cliente(barberia=barberia, condition=condition, barbero=barbero, name=10)
    c.start() # EJECUTAMOS CLIENTE

    # SOBRECARGAMOS EL LOCAL PARA QUE LOS QUE NO ALCANZEN SE RETIREN DEL LOCAL
    numero_clientes = [10,11,12,13,14,15,16,17,19,20,21,22,23,24,25,26,27,28,29,30,31,32]
    for n in numero_clientes: # CREAMOS HILOS DE CLIENTES PARA SER ATENDIDOS
        c=Cliente(barberia=barberia, condition=condition, barbero=barbero, name=n)
        c.start()


