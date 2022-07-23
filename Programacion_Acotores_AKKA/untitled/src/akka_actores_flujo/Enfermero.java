package akka_actores_flujo;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Enfermero extends UntypedActor {
    public enum Mensaje {
        OBTENER_CAMA
    }

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private static final long TIEMPO_OBTENER_CAMA = 2000;

    @Override
    public void onReceive(Object o) throws InterruptedException {
        log.info("[Enfermero] ha recibido el mensaje: \"{}\".", o);

        if (o == Mensaje.OBTENER_CAMA) {
            log.info("[Enfermero] está buscando una cama...");
            obtenerMinerales();
            log.info("[Enfermero] encontror una cama.");
            getSender().tell(Recepcionista.Mensaje.CAMA, getSelf());
        } else {
            unhandled(o);
        }
    }

    private void obtenerMinerales() throws InterruptedException {
        Thread.sleep(TIEMPO_OBTENER_CAMA);
    }
}