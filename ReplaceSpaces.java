/**
 *
 *替换空格：
 *1.把第一个指针指向字符串的末尾，把第二个指针指向替换后的字符串的末尾。
 *2.依次复制字符串的内容，直到第一个指针碰到第一个空格。
 *3.把第一个空格替换成%20，把第一个指针向前移动一格，把第二个指针向前移动3格
 *4.依次向前复制字符串中的字符，直到碰到空格
 *5.替换字符串中的倒数第二个空格，把第一个指针向前移动一格，第二个指针向前移动3格
 *
 */
public class ReplaceSpaces {
	
	public void replaceBlank(String str) {
		if (str == null || str.length() == 0) {
            return "";
        }
        int originalLength = str.length();
        int numberOfBlank = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                ++numberOfBlank;
        }
        int newLength = originalLength + numberOfBlank * 2;
        char[] newChars = new char[newLength];
        for (int i = 0; i < str.length(); i++)
            newChars[i] = str.charAt(i);
        int indexOfOrigin = originalLength-1;
        int indexOfNew = newLength-1;
        while (indexOfOrigin >= 0 && indexOfNew > indexOfOrigin) {
            if (newChars[indexOfOrigin] == ' ') {
                newChars[indexOfNew--] = '0';
                newChars[indexOfNew--] = '2';
                newChars[indexOfNew--] = '%';
            } else {
                newChars[indexOfNew--] = newChars[indexOfOrigin];
            }
            --indexOfOrigin;
        }
        return new String(newChars);
	}
}