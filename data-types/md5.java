public static void main(String[] args) {
    System.out.println(md5("123456"));
}

public static String md5(String input) {
    String result = "";
    try {
        MessageDigest md = MessageDigest.getInstance("md5");
        md.update(input.getBytes());
        byte[] digest = md.digest();
        result = byteToHex(digest);
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    return result;
}

public static String byteToHex(byte[] byteArr) {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b : byteArr) {
        stringBuilder.append(String.format("%02x", b));
    }
    return stringBuilder.toString();
}
