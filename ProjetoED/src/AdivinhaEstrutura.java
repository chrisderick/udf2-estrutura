import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//TODO: Arrumar quando tem entradas e saídas misturadas visto que o programa nao reconhece;
//TODO: Classificar como impossível quando um valor é removido do meio da estrutura;

public class AdivinhaEstrutura {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        Integer tamanho = s.nextInt();
        //Integer[] vetor = new Integer[tamanho];
        ArrayList<Integer> insercoes = new ArrayList<>();
        ArrayList<Integer> remocoes = new ArrayList<>();
        Integer tipoEstrutura = null;
        Integer maiorValor = 0;
        //Garante que os valores removidos existem na estrutura
        boolean existe = true;

        if(tamanho >= 1 && tamanho <= 1000) {
            //Permite a entrada de comandos na quantidade informada anteriormente
            for (int i = 0; i < tamanho; i++) {
                s = new Scanner(System.in);
                String linha = s.nextLine();

                //Confirma que um valor foi informado
                if (linha.length() > 2) {
                    //Armazena o comando (inserção(1)/remoção(2)) a ser executado no valor informado;
                    Integer valor = Integer.parseInt(linha.substring(2));
                    Integer comando = Integer.parseInt(String.valueOf(linha.charAt(0)));

                    //Verifica se o valor está nos conformes estabelecidos pelo enunciado
                    if (valor >= 0 && valor <= 100) {
                        //Verifica se está sendo realizada uma inserção ou uma remoção na estrutura
                        if (comando == 1) {
                            //vetor[i] = valor;
                            if (valor > maiorValor) maiorValor = valor;
                            insercoes.add(valor);
                        } else if (comando == 2) {
                            //Confere se o valor a ser removido já foi inserido antes
                            if (insercoes.contains(valor)) {
                                remocoes.add(valor);
                            } else {
                                tipoEstrutura = 0;
                                break;
                            }
                        } else {
                            tipoEstrutura = 0;
                            break;
                        }
                    } else {
                        tipoEstrutura = 0;
                        break;
                    }
                } else {
                    tipoEstrutura = 0;
                    break;
                }
            }
        } else {
            tipoEstrutura = 1;
        }

        //Comparações
        //Tipo de Estrutura 1: Not Sure
        if (tipoEstrutura == null) {
            if (tamanho == 1 || tamanho == 2) {
                tipoEstrutura = 1;
            } else if (tamanho > 3 && insercoes.size() == remocoes.size()) {
                //Confera se as listas estão invertidas
                boolean estaoInvertidas = true;
                int cont = remocoes.size()-1;
                for (Integer valor : insercoes) {
                    if (!valor.equals(remocoes.get(cont))) {
                        estaoInvertidas = false;
                        break;
                    }
                    cont--;
                }
                //Confera se as listas são iguais
                boolean estaoIguais = true;
                cont = 0;
                for (Integer valor : insercoes) {
                    if (!valor.equals(remocoes.get(cont))) {
                        estaoIguais = false;
                        break;
                    }
                    cont++;
                }
                //Confere se as listas estão ordenadas
                boolean estaOrdenada = true;
                //Estrutura é Pilha ou Fila de Prioridade
                if (estaoInvertidas) {
                    //Confera se as inserções estão em ordem crescente
                    Integer anterior = insercoes.get(0);
                    for (Integer valor : insercoes) {
                        //Não considerando valores iguais
                        if (valor.compareTo(anterior) < 0) {
                            estaOrdenada = false;
                            break;
                        }
                        anterior = valor;
                    }
                    //Confera se as remoções estão em ordem decrescente
                    anterior = remocoes.get(0);
                    for (Integer valor : remocoes) {
                        //Não considerando valores iguais
                        if (valor.compareTo(anterior) > 0) {
                            estaOrdenada = false;
                            break;
                        }
                        anterior = valor;
                    }
                    if (estaOrdenada) {
                        tipoEstrutura = 1;
                    }
                }
                //Estrutura é Fila normal ou de Prioridade
                else if (estaoIguais) {
                    //Confera se as inserções estão em ordem decrescente
                    Integer anterior = insercoes.get(0);
                    for (Integer valor : insercoes) {
                        //Não considerando valores iguais
                        if (valor.compareTo(anterior) > 0) {
                            estaOrdenada = false;
                            break;
                        }
                        anterior = valor;
                    }
                    //Confere se as remoções estão em ordem decrescente
                    anterior = remocoes.get(0);
                    for (Integer valor : remocoes) {
                        //Não considerando valores iguais
                        if (valor.compareTo(anterior) > 0) {
                            estaOrdenada = false;
                            break;
                        }
                        anterior = valor;
                    }
                    if (estaOrdenada) {
                        tipoEstrutura = 1;
                    }
                }
            }
            else if (remocoes.get(remocoes.size() - 1).equals(maiorValor)) {

            }
        }

        //Tipo de Estrutura 2: Pilha (stack)
        if (tipoEstrutura == null) {
            //São necessários no mínimo 4 comandos para determinar se a estrutura é uma pilha
            if (tamanho > 3 && !remocoes.isEmpty()){
                boolean pilha = true;
                int fimInsercoes = insercoes.size()-1;
                int inicioRemocoes = 0;
                //Verifica se as remoções feitas estão no padrão de pilha (LIFO)
                for (int i = remocoes.size()-1; i >= 0; i--){
                    if (!remocoes.get(inicioRemocoes).equals(insercoes.get(fimInsercoes))){
                        pilha = false;
                        break;
                    }
                    inicioRemocoes++;
                    fimInsercoes--;
                }
                if (pilha){
                    tipoEstrutura = 2;
                }
            }
        }

        //Tipo de Estrutura 3: Fila (queue)
        if (tipoEstrutura == null) {
            if (tamanho > 2 && !remocoes.isEmpty()) {
                boolean fila = true;
                int inicioInsercoes = 0;
                int inicioRemocoes = 0;
                //Verifica se as remoções feitas estão no padrão de fila (FIFO)
                for (int i = remocoes.size() - 1; i >= 0; i--) {
                    if (!remocoes.get(inicioRemocoes).equals(insercoes.get(inicioInsercoes))) {
                        fila = false;
                        break;
                    }
                    inicioInsercoes++;
                    inicioRemocoes++;
                }
                if (fila) {
                    tipoEstrutura = 3;
                }
            }
        }

        //Tipo de Estrutura 4: Fila de Prioridade (priority queue)
        if (tipoEstrutura == null) {
            //O primeiro valor a ser removido deve ser o maior dos valores inseridos
            if (tamanho > 3 && !remocoes.isEmpty() && remocoes.get(0).equals(maiorValor)) {
                boolean filapri = true;
                /*int inicioInsercoes = 0;
                int inicioRemocoes = 0;
                //Verifica se as remoções feitas estão no padrão de fila de prioridade (Remoção dos maiores valores em ordem)
                for (int i = remocoes.size() - 1; i >= 0; i--) {
                    if (!remocoes.get(inicioRemocoes).equals(insercoes.get(inicioInsercoes))) {
                        filapri = false;
                        break;
                    }
                    inicioInsercoes++;
                    inicioRemocoes++;
                }
                if (filapri) {
                    tipoEstrutura = 4;
                }*/
                if (filapri) {
                    tipoEstrutura = 4;
                }
            }
        }

        //Se nenhuma das comparações definir o valor de tipoEstrutura, esta a define como not sure
        if (tipoEstrutura == null) {
            tipoEstrutura = 1;
        }

        switch (tipoEstrutura) {
            case 0: {
                System.out.println("impossible");
                break;
            }
            case 1: {
                System.out.println("not sure");
                break;
            }
            case 2: {
                System.out.println("stack");
                break;
            }
            case 3: {
                System.out.println("queue");
                break;
            }
            case 4: {
                System.out.println("priority queue");
                break;
            }
        }
    }
}
