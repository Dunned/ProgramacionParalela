package akka_actores_flujo;

public class Main {

    public static void main(String[] args) {
        // RECIBE COMO ARGUMENTO LA CLASE DEL ACTOR PRINCIPAL, ES EL PRIMERO EN EJECUTARSE
        akka.Main.main(new String[]{Paciente.class.getName()});
    }
}
