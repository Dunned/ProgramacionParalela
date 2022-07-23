package akka_actores_flujo;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Recepcionista extends UntypedActor {
    public enum Mensaje {
        BUSCAR_CAMA,
        CAMA
    }

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    private static final long TIEMPO_BUSCAR_CAMA = 2000;
    private ActorRef paciente;
    private ActorRef enfermero;


    @Override
    public void preStart() {
        enfermero = getContext().actorOf(Props.create(Enfermero.class), "enfermero");
    }

    @Override
    public void onReceive(Object o) throws InterruptedException {
        log.info("[Recepcionista] ha recibido el mensaje: \"{}\".", o);

        if (o == Mensaje.BUSCAR_CAMA) {
            paciente = getSender(); //quien envio ese mensaje?
            enfermero.tell(Enfermero.Mensaje.OBTENER_CAMA, getSelf());
        } else if (o == Mensaje.CAMA) {
            log.info("[Recepcionista] esta agendando cita ...");
            agendarCita();
            log.info("[Recepcionista] ha agendado cita.");
            paciente.tell(Paciente.Mensaje.CAMA_NUEVA, getSelf());
        } else {
            unhandled(o);
        }
    }

    private void agendarCita() throws InterruptedException {
        Thread.sleep(TIEMPO_BUSCAR_CAMA);
    }

    @Override
    public void unhandled(Object message) {
        log.info("[Recepcionista] no sabe qué hacer ante el mensaje: \"{}\".", message);
    }
}