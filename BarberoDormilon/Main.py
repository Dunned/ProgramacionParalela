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
    barbero=Barbero(barberia=barberia, condition=condition, name='BARBERO Carlos Cacho') #CREAMOS UN BARBERO
    barbero.start() #INICIAMOS HILO DEL BARBERO
    barberia.start() # INICIAMOS HILO DE LA BARBERIA
    numero_clientes=['Eduardo Jauregui','Daniel Santos','William Cachique'] # CREAMOS 3 SUPUESTOS CLIENTES

    for n in numero_clientes:
        time.sleep(random.randint(0,2)) # CREAMOS OBJETOS CLIENTES (HILOS) PARA MANDAR A LA BARBERIA Y SER ATENDIDOS
        c=Cliente(barberia=barberia, condition=condition, barbero=barbero, name=n)
        c.start()

    time.sleep(20) # ESPERAMOS QUE PASEN 20 SEGUNDOS , EL BARBERO DEBERIA ESTAR DORMIDO Y DEBERIA DESPERTARSE
    c = Cliente(barberia=barberia, condition=condition, barbero=barbero, name="Patrick Pisaña")
    c.start() # EJECUTAMOS CLIENTE
    time.sleep(30) # HACEMOS QUE EL BARBERO SE VUELVA A DORMIR
    # SOBRECARGAMOS EL LOCAL PARA QUE LOS QUE NO ALCANZEN SE RETIREN DEL LOCAL
    numero_clientes = ['Duanne Barrios','Allison Garcia',
                       "Scot Martinez",'Grecia Martinez',
                       'Karol Zuniga','Felix Fernandez',
                       'Nadiuska Bances','Maria Lopez',
                       'Mariela Castillo','Diana Contreras',
                       'Stephany Rojas','Pedro Castillo',
                       'Ernesto Pimentel','Arnold Chavez',
                       'Gustavo Alania','Paolo Guerrero','Gianluca Lapadula',
                       'Edison Flores','Jefferson Farfan']
    for n in numero_clientes: # CREAMOS HILOS DE CLIENTES PARA SER ATENDIDOS
        c=Cliente(barberia=barberia, condition=condition, barbero=barbero, name=n)
        c.start()


