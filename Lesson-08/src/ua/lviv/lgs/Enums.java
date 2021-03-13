package ua.lviv.lgs;

import java.util.Scanner;

public class Enums {

	enum Seasons {
		WINTER, SPRING, SUMMER, FALL;
	}

	enum Months {
		JANUARY(31, Seasons.WINTER), FEBRUARY(28, Seasons.WINTER), MARCH(31, Seasons.SPRING), APRIL(30, Seasons.SPRING),
		MAY(31, Seasons.SPRING), JUNE(31, Seasons.SUMMER), JULY(30, Seasons.SUMMER), AUGUST(31, Seasons.SUMMER),
		SEPTEMBER(30, Seasons.FALL), OCTOBER(31, Seasons.FALL), NOVEMBER(30, Seasons.FALL),
		DECEMBER(31, Seasons.WINTER);

		final int days;
		final Seasons season;

		Months(int days, Seasons season) {
			this.days = days;
			this.season = season;
		}

		public Integer getDays() {
			return days;
		}

		public Seasons getSeason() {
			return season;
		}

	}

	public static void menu() {
		System.out.println("Press 1 for check if there is such a month");
		System.out.println("Press 2 to get all months with the same time of year");
		System.out.println("Press 3 to get all months that have the same number of days ");
		System.out.println("Press 4 to display all months with fewer days");
		System.out.println("Press 5 to Display all months that have more days");
		System.out.println("Press 6 to display next season ");
		System.out.println("Press 7 to display previous season ");
		System.out.println("Press 8 display all months that have an even number of days ");
		System.out.println("Press 9 display all months that have an odd number of days");
		System.out.println("Press 10 Display whether the month entered from the console has an even number of days");
	}

	public static void main(String[] args) {
		Months[] months = Months.values();
		Seasons[] seasonsArr = Seasons.values();
		Scanner scan = new Scanner(System.in);

		while (true) {
			menu();

			switch (scan.next()) {

			case "1": {
				System.out.println("Enter month");
				scan = new Scanner(System.in);
				String month = scan.next().toUpperCase();
				boolean flag = isMonthPresent(months, month);
				if (!flag) {
					System.out.println("Month doesn't exist");
					;
				}
				break;
			}
			case "2": {
				System.out.println("Enter season ");
				scan = new Scanner(System.in);
				String seasonScan = scan.next().toUpperCase();

				boolean flag = false;

				for (Months m : months) {
					if (m.getSeason().name().equals(seasonScan)) {

						flag = true;
					}
				}
				if (flag) {
					Seasons mf = Seasons.valueOf(seasonScan);

					for (Months m : months) {
						if (m.getSeason().toString().equalsIgnoreCase(seasonScan)) {
							System.out.println(m);
						}
					}
				}
				if (!flag) {
					System.out.println("Month doesn't exist");
					;
				}
				break;
			}

			case "3": {
				System.out.println("Enter number of days");
				scan = new Scanner(System.in);

				String days = scan.next().toUpperCase();

				boolean flag = false;

				for (Months m : months) {
					if (m.getDays().toString().equals(days)) {

						flag = true;
					}
				}
				if (flag) {

					for (Months m : months) {
						if (m.getDays().toString().equals(days)) {
							System.out.println(m);
						}
					}
				}

				break;
			}

			case "4": {
				System.out.println("Enter number of days");
				scan = new Scanner(System.in);

				String days = scan.next().toUpperCase();

				boolean flag = false;

				for (Months m : months) {
					if (m.getDays() < scan.nextInt()) {
						flag = true;
					}
				}
				if (flag) {

					for (Months m : months) {
						if (m.getDays().toString().equals(days)) {
							System.out.println(m);
						}
					}
				}

				break;
			}
			case "5": {
				System.out.println("Enter number of days");
				scan = new Scanner(System.in);

				String days = scan.next().toUpperCase();

				boolean flag = false;

				for (Months m : months) {
					if (m.getDays() > scan.nextInt()) {
						flag = true;
					}
				}
				if (flag) {

					for (Months m : months) {
						if (m.getDays().toString().equals(days)) {
							System.out.println(m);
						}
					}
				}

				break;
			}
			case "6": {
				System.out.println("Enter season");
				scan = new Scanner(System.in);
				String season = scan.next().toUpperCase();

				boolean flag = isSeasonPresent(seasonsArr, season);

				if (flag) {
					Seasons seas = Seasons.valueOf(season);
					int ordinal = seas.ordinal();

					if (ordinal == seasonsArr.length - 1) {
						ordinal = 0;
						System.out.println(seasonsArr[ordinal]);
					} else {
						System.out.println(seasonsArr[ordinal + 1]);
					}
				}

				if (!flag) {
					System.out.println("Season doesn't exist");
					;
				}
				break;
			}
			case "7": {
				System.out.println("Enter season");
				scan = new Scanner(System.in);
				String season = scan.next().toUpperCase();

				boolean flag = isSeasonPresent(seasonsArr, season);

				if (flag) {
					Seasons seas = Seasons.valueOf(season);
					int ordinal = seas.ordinal();

					if (ordinal == seasonsArr.length) {
						ordinal = 3;
						System.out.println(seasonsArr[ordinal]);
					} else {
						System.out.println(seasonsArr[ordinal + 3]);
					}
				}

				if (!flag) {
					System.out.println("Season doesn't exist");
					;
				}

				break;
			}
			case "8": {
				scan = new Scanner(System.in);

				for (Months m : months) {
					if (m.getDays() % 2 == 0) {
						System.out.println(m);
					}
				}
				break;
			}
			case "9": {

				scan = new Scanner(System.in);

				for (Months m : months) {
					if (m.getDays() % 2 == 0) {

					} else
						System.out.println(m);
				}

				break;
			}
			case "10": {

				System.out.println("Enter month");
				scan = new Scanner(System.in);

				String month = scan.nextLine();
				try {
					Months m = Months.valueOf(month);
					if (m.days % 2 == 0) {
						System.out.println(month + " has an even number of days");
					} else {
						System.out.println(month + " have an odd number of days");
					}

				} catch (IllegalArgumentException e) {
					System.out.println("Can't find " + month);
				}

			}
			default:
				break;
			}
		}

	}

	private static boolean isMonthPresent(Months[] months, String month) {
		boolean flag = false;

		for (Months m : months) {
			if (m.name().equals(month)) {
				System.out.println("Month exist ");
				flag = true;

			}
		}
		return flag;
	}

	private static boolean isSeasonPresent(Seasons[] seasons, String seas) {
		boolean flag = false;

		for (Seasons s : seasons) {
			if (s.name().equals(seas)) {
				System.out.println("Season exist ");
				flag = true;

			}
		}
		return flag;
	}
}
