package br.com.safeJourney.util;

// Importações necessárias
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

    // Método para criptografar uma mensagem usando SHA-256
    public static String criptografar(String mensagem) throws NoSuchAlgorithmException {
        // Cria uma instância de MessageDigest com o algoritmo SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        
        // Converte a mensagem em um array de bytes usando a codificação UTF-8
        byte[] hashBytes = digest.digest(mensagem.getBytes(StandardCharsets.UTF_8));
        
        // Converte o array de bytes em uma string hexadecimal e a retorna
        return bytesParaHex(hashBytes);
    }

    // Método auxiliar para converter um array de bytes em uma string hexadecimal
    private static String bytesParaHex(byte[] hash) {
        // StringBuilder para armazenar a representação hexadecimal
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        
        // Itera sobre cada byte do array de hash
        for (int i = 0; i < hash.length; i++) {
            // Converte o byte para um valor hexadecimal
            String hex = Integer.toHexString(0xff & hash[i]);
            
            // Adiciona um '0' no início se o valor hexadecimal tiver apenas um dígito
            if (hex.length() == 1) {
                hexString.append('0');
            }
            
            // Adiciona o valor hexadecimal ao StringBuilder
            hexString.append(hex);
        }
        
        // Retorna a representação hexadecimal como string
        return hexString.toString();
    }
}
