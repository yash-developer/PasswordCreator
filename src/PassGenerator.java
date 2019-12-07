
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassGenerator {
	public static String SYMBOL = "!#$%&*+,-.=?@^_`|~";
	public static String NUMBER = "0123456789";
	public static String LOWERCASE = "abcdefghijkmnopqrstuvwxyz";
	public static String UPPERCASE = "ABCDEFGHIJKMNOPQRSTUVWXYZ";
	public static char[] symbolarr = SYMBOL.toCharArray();
	public static char[] numberarr = NUMBER.toCharArray();
	public static char[] lowcasearr = LOWERCASE.toCharArray();
	public static char[] upcasearr = UPPERCASE.toCharArray();
	public static char[] allcharsarr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int symbols, numbers, loCaseChars, upCaseChars;
		int maxLength;
		boolean bool = true;
		String allChars = "";
		String Password = "";

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Length of password you want: ");
		maxLength = scan.nextInt();

		String Regex_start = "(";
		String Regex_digits = "(?=.*\\d)";
		String Regex_symbols = "(?=.*[\\.\\^\\$\\*\\+\\?\\|!#%&\\-=@_~])";
		String Regex_lowercases = "(?=.*[a-z])";
		String Regex_uppercases = "(?=.*[A-Z])";
		String Regex_end = ".{3," + maxLength + "})";
		String regexB = "";
		Random rand = new Random();
		Pattern r2;

		// String regexA =
		// "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\.\\^\\$\\*\\+\\?\\|!#%&\\-=@_~]).{8,12})";
		if (maxLength > 3) {

			System.out.print("Press 1 to include Symbols: ");
			symbols = scan.nextInt();
			if (symbols == 1) {
				allChars += SYMBOL;

				System.out.print("Press 1 to include Numbers: ");
				numbers = scan.nextInt();
				if (numbers == 1) {
					allChars += NUMBER;

					System.out.print("Press 1 to include Lower Case Characters: ");
					loCaseChars = scan.nextInt();
					if (loCaseChars == 1) {
						allChars += LOWERCASE;

						System.out.print("Press 1 to include Upper Case Characters: ");
						upCaseChars = scan.nextInt();
						if (upCaseChars == 1) {
							allChars += UPPERCASE;
							regexB = Regex_start + Regex_digits + Regex_symbols + Regex_lowercases + Regex_uppercases
									+ Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
								builder.append(numberarr[rand.nextInt(numberarr.length)]);
								builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
								builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						} else {
							regexB = Regex_start + Regex_digits + Regex_symbols + Regex_lowercases + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
								builder.append(numberarr[rand.nextInt(numberarr.length)]);
								builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						}
					} else {

						System.out.print("Press 1 to include Upper Case Characters: ");
						upCaseChars = scan.nextInt();
						if (upCaseChars == 1) {
							allChars += UPPERCASE;
							regexB = Regex_start + Regex_digits + Regex_symbols + Regex_uppercases + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
								builder.append(numberarr[rand.nextInt(numberarr.length)]);
								builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						} else {
							regexB = Regex_start + Regex_digits + Regex_symbols + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
								builder.append(numberarr[rand.nextInt(numberarr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						}
					}
				} else {

					System.out.print("Press 1 to include Lower Case Characters: ");
					loCaseChars = scan.nextInt();
					if (loCaseChars == 1) {
						allChars += LOWERCASE;

						System.out.print("Press 1 to include Upper Case Characters: ");
						upCaseChars = scan.nextInt();
						if (upCaseChars == 1) {
							allChars += UPPERCASE;
							regexB = Regex_start + Regex_symbols + Regex_lowercases + Regex_uppercases + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
								builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
								builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						} else {
							regexB = Regex_start + Regex_symbols + Regex_lowercases + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
								builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						}
					} else {

						System.out.print("Press 1 to include Upper Case Characters: ");
						upCaseChars = scan.nextInt();
						if (upCaseChars == 1) {
							allChars += UPPERCASE;
							regexB = Regex_start + Regex_symbols + Regex_uppercases + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
								builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						} else {
							regexB = Regex_start + Regex_symbols + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(symbolarr[rand.nextInt(symbolarr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						}
					}
				}
			} else {

				System.out.print("Press 1 to include Numbers: ");
				numbers = scan.nextInt();
				if (numbers == 1) {
					allChars += NUMBER;

					System.out.print("Press 1 to include Lower Case Characters: ");
					loCaseChars = scan.nextInt();
					if (loCaseChars == 1) {
						allChars += LOWERCASE;

						System.out.print("Press 1 to include Upper Case Characters: ");
						upCaseChars = scan.nextInt();
						if (upCaseChars == 1) {
							allChars += UPPERCASE;
							regexB = Regex_start + Regex_digits + Regex_lowercases + Regex_uppercases + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(numberarr[rand.nextInt(numberarr.length)]);
								builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
								builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						} else {
							regexB = Regex_start + Regex_digits + Regex_lowercases + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(numberarr[rand.nextInt(numberarr.length)]);
								builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						}
					} else {

						System.out.print("Press 1 to include Upper Case Characters: ");
						upCaseChars = scan.nextInt();
						if (upCaseChars == 1) {
							allChars += UPPERCASE;
							regexB = Regex_start + Regex_digits + Regex_uppercases + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(numberarr[rand.nextInt(numberarr.length)]);
								builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						} else {
							regexB = Regex_start + Regex_digits + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(numberarr[rand.nextInt(numberarr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						}
					}
				} else {

					System.out.print("Press 1 to include Lower Case Characters: ");
					loCaseChars = scan.nextInt();
					if (loCaseChars == 1) {
						allChars += LOWERCASE;

						System.out.print("Press 1 to include Upper Case Characters: ");
						upCaseChars = scan.nextInt();
						if (upCaseChars == 1) {
							allChars += UPPERCASE;
							regexB = Regex_start + Regex_lowercases + Regex_uppercases + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
								builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						} else {
							regexB = Regex_start + Regex_lowercases + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(lowcasearr[rand.nextInt(lowcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						}
					} else {

						System.out.print("Press 1 to include Upper Case Characters: ");
						upCaseChars = scan.nextInt();
						if (upCaseChars == 1) {
							allChars += UPPERCASE;
							regexB = Regex_start + Regex_uppercases + Regex_end;
							allcharsarr = allChars.toCharArray();
							r2 = Pattern.compile(regexB);
							while (bool) {
								StringBuilder builder = new StringBuilder();
								builder.append(upcasearr[rand.nextInt(upcasearr.length)]);
								for (int i = builder.length(); i < maxLength; i++) {
									builder.append(allcharsarr[rand.nextInt(allcharsarr.length)]);
								}
								Password = builder.toString();
								Password = shuffle(Password);
								Matcher m = r2.matcher(Password);
								if (m.matches()) {
									// bool = false;
									break;
								}
							}
							System.out.print("Your Generated Password: " + Password);
						} else {
							System.out.println("You need Atleast One thing to Create a Password");
						}
					}
				}
			}
		} else {
			System.out.println("You should atleast choose a passwords with length more than 8 characters");
		}
		scan.close();
	}

	public static String shuffle(String input) {
		List<Character> characters = new ArrayList<Character>();
		StringBuilder output = new StringBuilder(input.length());
		for (char c : input.toCharArray()) {
			characters.add(c);
		}
		while (characters.size() != 0) {
			int randPicker = (int) (Math.random() * characters.size());
			output.append(characters.remove(randPicker));
		}
		return output.toString();
	}
}
