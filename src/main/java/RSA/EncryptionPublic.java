package RSA;

import javax.crypto.Cipher;
import javax.swing.JFileChooser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class EncryptionPublic {
    
    /**
     * Cifra un mensaje utilizando una clave pública desde un archivo.
     *
     * @param message El mensaje a cifrar.
     * @return El mensaje cifrado en Base64.
     * @throws Exception Si ocurre un error durante el cifrado.
     */
    public String encryptWithPublicKey(String message) throws Exception {
        String publicKeyPath = chooseFile("Seleccione el archivo de la clave pública");
        if (publicKeyPath == null) {
            throw new IOException("No se seleccionó ningún archivo de clave pública.");
        }

        // Leer la clave pública del archivo
        String publicKeyBase64 = readKeyFromFile(publicKeyPath);

        // Decodificar la clave pública desde Base64
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64);

        // Reconstruir la clave pública
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        // Configurar el cifrado
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        // Cifrar el mensaje
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());

        // Devolver el mensaje cifrado en formato Base64
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * Descifra un mensaje cifrado utilizando una clave privada desde un archivo.
     *
     * @param encryptedMessage El mensaje cifrado en Base64.
     * @return El mensaje descifrado.
     * @throws Exception Si ocurre un error durante el descifrado.
     */
    public String decryptWithPrivateKey(String encryptedMessage) throws Exception {
        // Seleccionar el archivo de clave privada
        String privateKeyPath = chooseFile("Seleccione el archivo de la clave privada");
        if (privateKeyPath == null) {
            throw new IOException("No se seleccionó ningún archivo de clave privada.");
        }

        // Leer la clave privada del archivo
        String privateKeyBase64 = readKeyFromFile(privateKeyPath);

        // Decodificar la clave privada desde Base64
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);

        // Reconstruir la clave privada
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // Configurar el descifrado
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        // Descifrar el mensaje
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));

        // Devolver el mensaje descifrado como cadena
        return new String(decryptedBytes);
    }

    /**
     * Lee el contenido de un archivo que contiene una clave en formato Base64.
     *
     * @param filePath La ruta del archivo.
     * @return La clave como una cadena en Base64.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    private String readKeyFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath))).trim();
    }

    /**
     * Abre un JFileChooser para seleccionar un archivo.
     *
     * @param dialogTitle El título del diálogo.
     * @return La ruta del archivo seleccionado o null si se cancela.
     */
    private String chooseFile(String dialogTitle) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(dialogTitle);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
}
