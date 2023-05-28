package br.ufpb.dcx.morangofy.end;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuardarMusicas {
    private String arquivoDeMusicas = "Músicas.txt";
    private GravarDados gravador;

    public GuardarMusicas() {
        this.gravador = new GravarDados();
    }
}
