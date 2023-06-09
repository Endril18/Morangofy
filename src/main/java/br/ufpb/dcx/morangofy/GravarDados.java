package br.ufpb.dcx.morangofy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravarDados {
    public List<String> recuperaStringDeArquivo (String nomeArquivo) throws IOException {
        BufferedReader leitor = null;
        List<String> stringLida = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto;
            do {
                texto = leitor.readLine();
                if(texto != null){
                    stringLida.add(texto);
                }
            } while (texto != null);
        } finally {
            if(leitor != null) {
                leitor.close();
            }
        }
        return stringLida;
    }

    public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo) throws IOException {
        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            for(String s: texto) {
                gravador.write(s);
            }
        } finally {
            if(gravador != null) {
                gravador.close();
            }
        }
    }
}