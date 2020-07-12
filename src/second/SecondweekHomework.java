// 자바교육 2주차 과제
// 류건우
package second;

import java.util.Random;

public class SecondweekHomework {
	public static void main(String[] args) {

		int student_size = 6; // 학생수
		int subject_size = 7; // 과목수
		Random rand = new Random();
		String student[] = { "채송화", "이익준", "안정원", "김준완", "양석형", "한겨울" };
		String str[] = { "국어", "영어", "수학", "사회", "과학", "HTML", "JAVA", "합계", "평균", "석차" };
		int[] sum = new int[student_size]; // 사람별 합계
		double[] avg = new double[student_size]; // 사람별 평균
		int[] subjectsum = new int[subject_size]; // 과목별 합계
		double[] subjectavg = new double[subject_size]; // 과목별 평균
		int[] rank = new int[student_size]; // 사람별 석차

		// 6명의 7과목의 점수를 저장할 수 있는 변수 score를 선언
		int[][] score = new int[6][7];

		// score의 각방의 점수를 0~100점사이의 랜덤한 정수값으로 초기화
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				int randomscore = rand.nextInt(101);
				score[i][j] = randomscore;
			}
		}

		// 사람별 합과 평균, 과목별 합
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				sum[i] += score[i][j];
				subjectsum[j] += score[i][j];
			}
			avg[i] = (double) sum[i] / subject_size;
		}

		// 과목별 평균
		for (int i = 0; i < subjectavg.length; i++) {
			subjectavg[i] = (double) subjectsum[i] / student_size;
		}

		// 사람별 석차
		for (int i = 0; i < student_size; i++) {
			rank[i] = 1;// 모든 학생 석차 1로 초기화
			for (int j = 0; j < student_size; j++) {
				if (sum[i] < sum[j]) {
					rank[i]++;
				}
			}
		}

		// 성적별 sort-오름차순
		for (int i = 0; i < student_size; i++) {
			for (int j = i + 1; j < student_size; j++) {

				if (rank[i] > rank[j]) {
					String temp_student = student[i];
					student[i] = student[j];
					student[j] = temp_student;


					for (int k = 0; k < subject_size; k++) {
						int temp_score = score[i][k];
						score[i][k] = score[j][k];
						score[j][k] = temp_score;
					}

					int temp_sum = sum[i];
					sum[i] = sum[j];
					sum[j] = temp_sum;
					
					double temp_avg = avg[i];
					avg[i] = avg[j];
					avg[j] = temp_avg;

					int temp_rank = rank[i];
					rank[i] = rank[j];
					rank[j] = temp_rank;
				}
			}
		}

		// 과목 및 합계, 평균 , 석차 console에 표시
		for (int i = 0; i < str.length; i++) {
			System.out.print("\t" + str[i]);
		}
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");

		for (int i = 0; i < score.length; i++) {
			System.out.print(student[i]);
			for (int j = 0; j < score[i].length; j++) {
				System.out.print("\t" + score[i][j]);
			}

			System.out.printf("\t%d \t%.2f \t%d", sum[i], avg[i], rank[i]);
			System.out.println();
		}

		System.out.println("-------------------------------------------------------------------------------------");
		// 과목합계
		System.out.print("과목합계");
		for (int i = 0; i < subjectsum.length; i++) {
			System.out.print("\t" + subjectsum[i]);
		}
		System.out.println();

		// 과목평균
		System.out.print("과목평균");
		for (int i = 0; i < subjectavg.length; i++) {
			System.out.printf("\t%.2f", subjectavg[i]);
		}
		System.out.println();

		System.out.println("-------------------------------------------------------------------------------------");
	}

}
