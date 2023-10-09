package controle_de_candidatos;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = { "Felipe", "Marcia", "Júlia", "Paula", "Augusto" };
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato Realizado com sucesso!");
        } while (continuarTentando && tentativasRealizadas < 3);
        if (atendeu)
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa ");
        else
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas "
                    + tentativasRealizadas);
    }

    // método auxiliar de aleatoriedade
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = { "Felipe", "Marcia", "Júlia", "Paula", "Augusto" };
        System.out.println("Impressão da lista de candidatos, informando o índice do elemento:");
        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de número " + (indice + 1) + " é " + candidatos[indice]);
        }

        System.out.println("Forma abreviada de interação via for each: ");
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = { "Felipe", "Marcia", "Paula", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela",
                "Jorge" };
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out
                    .println("Candidato(a) " + candidato + " solicitou este valor de salário:  " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("Candidato(a) " + candidato + " foi selecionado(a) para a vaga.\n");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido)
            System.out.println("Ligar para o candidato com contra proposta");
        else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}
