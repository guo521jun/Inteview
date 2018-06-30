/**
 *
 *正则表达式匹配
 *每次从字符数组中拿出一个字符与模式中的字符进行匹配，如果模式中的字符是'.'它可以匹配
 *字符数组中的任意字符，如果模式中的字符不是'.'，并且和字符数组中的字符相同，则匹配成功
 *接着匹配后面的字符。
 *
 */
public class RegularExpressions {
	
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null)
			return false;
		matchCore(str, pattern);
	}
	
	public boolean matchCore(char[] str, char[] pattern) {
		if (str[0] == ' ' && pattern[0] == ' ')
			return true;
		if (str[0] != ' ' && pattern[0] == ' ')
			return false;
		if (pattern[1] == '*') {
			if (str[0] == pattern[0] || (pattern[0] == '.' && str[0] != ' '))
				return matchCore(str[1], pattern[2])
			           || matchCore(str[1], pattern[0])
					   || matchCore(str[0], pattern[2]);
			else
				matchCore(str[0], pattern[2]);
		}
		if (str[0] == pattern[0] || (pattern[0] == '.' && str[0] != ' '))
			return matchCore(str[1], pattern[1]);
		return false;
	}
}