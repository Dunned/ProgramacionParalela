package akka_actores_flujo;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Paciente extends UntypedActor {
    public enum Mensaje {
        CAMA_NUEVA,
        SALUDO
    }

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    /*acciones previas a la recepción del primer mensaje que reciban*/
    @Override
    public void preStart() {
        /*Creacion de actores mediante otro actor propos = instancia de config, nombre clase a crear*/
        /*Devuelve referencia de actor creado*/
        final ActorRef recepcionista = getContext().actorOf(Props.create(Recepcionista.class), "recepcionista");
        /*Metodo teel mandar mensajes*/
        recepcionista.tell(Recepcionista.Mensaje.BUSCAR_CAMA, getSelf());
        recepcionista.tell(Mensaje.SALUDO, getSelf());
    }

    @Override
    public void onReceive(Object o) { /*A la espera de recibir mensaje*/
        log.info("[Paciente] ha recibido el mensaje: \"{}\".", o);

        if (o == Mensaje.CAMA_NUEVA) {
            getContext().stop(getSelf());
        } else {
            unhandled(o); /*ACtor recibe mensaje que no sabe como manejar*/
        }
    }
}