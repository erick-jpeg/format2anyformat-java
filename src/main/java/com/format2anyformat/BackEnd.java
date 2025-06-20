// Classe BackEnd.java
package com.format2anyformat;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe BackEnd contendo o funcionamento interno do programa em relação ao FrontEnd
 * @author erick-jpeg
 * @version 1.0
 */
public class BackEnd {
    /**
     * Atributo instancia do FrontEnd
     */
    private FrontEnd frontEnd;

    /**
     * Atributos para seleção dos caminhos dos arquivos e o nome dos mesmos na caixa de selação
     */
    ArrayList<String> filePathList = new ArrayList<>();
    String checkBoxSelection = "";

    /**
     * Método construtora de BackEnd
     * @author erick-jpeg
     * @version 1.0
     */
    public BackEnd() {

    }

    /**
     * Método para conversão dos arquivos
     * @author erick-jpeg
     * @version 1.0
     */
    public void handleFileConversion() throws IOException {
        // Obtém a lista de caminhos dos arquivos selecionados e a seleção da checkbox
        // do FrontEnd
        filePathList = frontEnd.getSelectedFilePath();
        checkBoxSelection = frontEnd.getCheckBoxSelection();

        // Verifica se a seleção da checkbox não está vazia
        if (!checkBoxSelection.isEmpty()) {
            // Verifica se a seleção não é "PDF"
            if (!checkBoxSelection.equals("PDF")) {
                // Itera sobre cada caminho de arquivo na lista
                for (String filePath : filePathList) {
                    // Verifica se a seleção é "PNG"
                    if (checkBoxSelection.equals("PNG")) {
                        try {
                            // Converte o arquivo para PNG e obtém a mensagem de retorno
                            FileConverterUtils convert = new FileConverterUtils(filePath);
                            String message = convert.getFilePNG();
                            // Define a mensagem no FrontEnd
                            frontEnd.setMessage(message);
                        } catch (IOException ex) {
                            // Imprime o stack trace se ocorrer uma exceção de IO
                            ex.printStackTrace();
                        }
                    } else if (checkBoxSelection.equals("JPEG")) { // Verifica se a seleção é "JPEG"
                        try {
                            // Converte o arquivo para JPEG e obtém a mensagem de retorno
                            FileConverterUtils convert = new FileConverterUtils(filePath);
                            String message = convert.getFileJPEG();
                            // Define a mensagem no FrontEnd
                            frontEnd.setMessage(message);
                        } catch (IOException ex) {
                            // Imprime o stack trace se ocorrer uma exceção de IO
                            ex.printStackTrace();
                        }
                    }
                }
            } else { // Se a seleção for "PDF"
                // Converte os arquivos para PDF e obtém a mensagem de retorno
                FileConverterUtils convert = new FileConverterUtils(filePathList);
                String message = convert.getFilePDF();
                // Define a mensagem no FrontEnd
                frontEnd.setMessage(message);
            }
        } else {
            // Se nenhuma checkbox foi selecionada, define a mensagem no FrontEnd
            String message = "Nenhuma checkBox selecionada!";
            frontEnd.setMessage(message);
        }
    }

    /**
     * Método SET para instanciar um FrontEnd como atributo
     * @param frontEnd recebe uma instancia de FrontEnd
     * @author erick-jpeg
     * @version 1.0
     */
    public void setFrontEnd(FrontEnd frontEnd) {
        this.frontEnd = frontEnd;
    }
}