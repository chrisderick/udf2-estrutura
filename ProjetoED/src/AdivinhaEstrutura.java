//Projeto Final de Estrutura de Dados
//Aluno: Christhyan Derick Dias Barbosa (19828322) e Robson Ribeiro Lucio (19910622)
//Turma: 2D2
//Professora: Iasmini Lima

import java.util.*;

public class AdivinhaEstrutura {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numComandos = s.nextInt();

        //Declaracao das estruturas
        Stack<Integer> pilha = new Stack<>();
        Queue<Integer> fila = new LinkedList<>();
        PriorityQueue<Integer> filapri = new PriorityQueue<>();
        //Variaveis que informam o tipo da estrutura
        boolean isStack = true;
        boolean isQueue = true;
        boolean isPriority = true;

        for (int i = 0; i < numComandos; i++) {
            s = new Scanner(System.in);
            String linha = s.nextLine();

            //Confirma que um valor foi informado
            if (linha.length() > 2) {
                //Armazena o comando (insercao(1)/remocao(2)) a ser executado no valor informado
                int comando = Integer.parseInt(String.valueOf(linha.charAt(0)));
                Integer valor = Integer.parseInt(linha.substring(2));

                //Verifica se esta sendo realizada uma insercao ou uma remocao na estrutura
                if (comando == 1) {
                    //Insere o valor em cada uma das estruturas
                    pilha.push(valor);
                    fila.offer(valor);
                    filapri.offer(valor);
                }
                if (comando == 2) {
                    if (pilha.isEmpty() || fila.isEmpty() || filapri.isEmpty()){
                        isStack = false;
                        isQueue = false;
                        isPriority = false;
                    } else {
                        //Se o valor a ser removido(pelo pop) for diferente do valor passado, a estrutura nao sera uma pilha
                        Integer valorRemovido = pilha.pop();
                        if (!valorRemovido.equals(valor)) {
                            isStack = false;
                        }

                        //Se o valor a ser removido(pelo poll) for diferente do valor passado, a estrutura nao sera uma fila
                        valorRemovido = fila.poll();
                        if (!valorRemovido.equals(valor)) {
                            isQueue = false;
                        }

                        //Se o valor a ser removido for diferente do maior valor aqui, a estrutura nao sera uma fila de prioridade
                        Integer maiorValor = 0;
                        for (Integer value : filapri) {
                            if (value > maiorValor) {
                                maiorValor = value;
                            }
                        }
                        if (!valor.equals(maiorValor)) {
                            isPriority = false;
                        }
                        //Ao final, o valor e removido
                        filapri.remove(valor);
                    }
                }
            } else {
                isStack = false;
                isQueue = false;
                isPriority = false;
            }
        }

        //Comparacoes
        if ((isStack && isQueue) || (isStack && isPriority) || (isQueue && isPriority)){
            System.out.println("not sure");
        } else if (isStack) {
            System.out.println("stack");
        } else if (isQueue) {
            System.out.println("queue");
        } else if (isPriority) {
            System.out.println("priority queue");
        } else {
            System.out.println("impossible");
        }
    }
}