package ccu.pllab.tcgen3.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FileUtil {
  /**
   * �R�����w�� .ecl �ɮס]�ȭ��ɮסA�����j�R���ؿ��^�C
   * <p>
   * �䴩�T�ؿ�J�G
   * </p>
   * <ol>
   * <li>�����ɦW�A�Ҧp <code>"C:/tmp/grade_path.ecl"</code></li>
   * <li>���t���ɦW�A�Ҧp <code>"C:/tmp/grade_path"</code>�]�۰ʸ� <code>.ecl</code>�^</li>
   * <li>�¥ؿ��A�Ҧp <code>"C:/tmp"</code>�]�w�]��w <code>output.ecl</code>�^</li>
   * </ol>
   *
   * @param rawPath �n�R�������|
   * @return <code>true</code> - �w���\�R��<br>
   *         <code>false</code> - �ɮפ��s�b�A������R��
   * @throws IOException �Y�ؼЬ��ؿ��]�B���M�ιw�]�ɮס^�B�v�������� I/O ���~
   */
  public static boolean deleteEclFile(Path rawPath) throws IOException {

    // 1. �Ѽ��ˬd
    Objects.requireNonNull(rawPath, "Path ���i�� null");

    // 2. �ѪR�̲ץؼи��|�]�ɰ��ɦW / �ؿ� �� output.ecl�^
    Path target;
    if (Files.isDirectory(rawPath)) {
      target = rawPath.resolve("output.ecl"); // �ؿ� �� �R�� output.ecl
    } else if (rawPath.toString().endsWith(".ecl")) {
      target = rawPath; // �w�t .ecl
    } else {
      target = rawPath.resolveSibling(rawPath.getFileName() + ".ecl"); // �۰ʸ� .ecl
    }

    // 3. �T�O�ؼФ��O�ؿ�
    if (Files.isDirectory(target)) {
      throw new IOException("�ؼЬ���Ƨ��A�Ȥ䴩�R���ɮסG" + target);
    }

    // 4. ���էR��
    boolean deleted = Files.deleteIfExists(target);

    // 5. ���G����
    if (deleted) {
      // System.out.println("CLP(ECLiPSe) Code-file deleted successfully�G " + target);
    } else {
      System.out.println("�ɮפ��s�b�A�L�ݧR���G " + target);
    }
    return deleted;
  }

  /**
   * �R�����w���ɮס]�ȭ��ɮסA���B�z�ؿ����j�^�C
   *
   * @param target �n�R�����ɮ׸��|
   * @return true - �w���\�R�� false - �ɮפ��s�b�A������R��
   * @throws IOException �Y�ؼЬ��ؿ��B�L�����v���A�ΧR���ɵo�� I/O ���~
   */
  public static boolean deleteEclFile_no(Path target) throws IOException {

    // 1. �Ѽ��ˬd
    Objects.requireNonNull(target, "Path ���i�� null");

    // 2. �Ȥ��\�R���ɮסA�Y���ؿ������ڵ�
    if (Files.isDirectory(target)) {
      throw new IOException("�ؼЬ���Ƨ��A�Ȥ䴩�R���ɮסG" + target);
    }

    // 3. ���էR���A�Y���s�b�h�^�� false
    boolean deleted = Files.deleteIfExists(target);

    // 4. �T������
    if (deleted) {
      System.out.println("CLP(ECLiPSe)  Code-file deleted successfully�G " + target);
    } else {
      System.out.println("�ɮפ��s�b�A�L�ݧR���G " + target);
    }
    return deleted;
  }

  public static boolean filecoverwrite(String fileName, String content) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
      writer.write(content);
      System.out.println("���\�g�J�ɮ�: " + fileName);
      return true;
    } catch (IOException e) {
      System.err.println("�g�J�ɮ׮ɵo�Ϳ��~: " + e.getMessage());
      return false;
    }
  }

}
