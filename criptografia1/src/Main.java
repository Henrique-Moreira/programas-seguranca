import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//      ArrayList<String> alfabeto = new ArrayList<String>();
        ArrayList<String> digitosCriptografados = new ArrayList<String>();
        ArrayList<String> digitosFrase = new ArrayList<String>();
        ArrayList<Integer> senha = new ArrayList<Integer>();
        String frase;
        String fraseCriptografada = "";


        // cria o alfabeto iniciando com espaço e terminando com "ç".
//        alfabeto.add(" ");
//        for(int i = 97; i < 122; i++) {
//            alfabeto.add(String.valueOf((char) i));
//        }
//        alfabeto.add("ç");

        // coleta a frase a ser criptografada.
        System.out.print("Digite a frase a ser criptografada: ");
        frase = sc.nextLine();

        // adiciona zeros ao final da frase para a quantidade de caracteres ser divisível por 5.
        if(frase.length() % 5 != 0) {
            int resto = frase.length() % 5;

            for (int i = 0; i < 5-resto; i++) {
                frase+=" ";
            }
        }

        // coleta a senha.
        System.out.println("Agora digite a senha de 5 dígitos: ");
        for(int i =0; i<5; i++) {
            System.out.print("Digite o digito " + (i+1) + " de 5 dígitos: ");
            senha.add(sc.nextInt());
        }

        // transforma a frase em array de char
        for(int i = 0; i < frase.length(); i++) {
            digitosFrase.add(String.valueOf(frase.charAt(i)));
        }

        // popula o array da msg criptografada
        int indexSenha = 0;
        for(int i = 0; i < digitosFrase.size(); i++) {
            indexSenha = (indexSenha == 5) ? 0 : indexSenha;
            System.out.println(indexSenha + " = " + senha.get(indexSenha));
            digitosCriptografados.add(String.valueOf((char) ((int) digitosFrase.get(i).charAt(0) + senha.get(indexSenha))));
            indexSenha++;
        }
//        System.out.println(digitosFrase);
//        System.out.println(digitosCriptografados);

        for (String digitoCriptografado: digitosCriptografados) {
            fraseCriptografada+= digitoCriptografado;
        }

        System.out.println("Frase Criptografada = " + fraseCriptografada);

        sc.close();
    }
}
