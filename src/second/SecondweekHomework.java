// �ڹٱ��� 2���� ����
// ���ǿ�
package second;

import java.util.Random;

public class SecondweekHomework {
	public static void main(String[] args) {

		int student_size = 6; // �л���
		int subject_size = 7; // �����
		Random rand = new Random();
		String student[] = { "ä��ȭ", "������", "������", "���ؿ�", "�缮��", "�Ѱܿ�" };
		String str[] = { "����", "����", "����", "��ȸ", "����", "HTML", "JAVA", "�հ�", "���", "����" };
		int[] sum = new int[student_size]; // ����� �հ�
		double[] avg = new double[student_size]; // ����� ���
		int[] subjectsum = new int[subject_size]; // ���� �հ�
		double[] subjectavg = new double[subject_size]; // ���� ���
		int[] rank = new int[student_size]; // ����� ����

		// 6���� 7������ ������ ������ �� �ִ� ���� score�� ����
		int[][] score = new int[6][7];

		// score�� ������ ������ 0~100�������� ������ ���������� �ʱ�ȭ
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				int randomscore = rand.nextInt(101);
				score[i][j] = randomscore;
			}
		}

		// ����� �հ� ���, ���� ��
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				sum[i] += score[i][j];
				subjectsum[j] += score[i][j];
			}
			avg[i] = (double) sum[i] / subject_size;
		}

		// ���� ���
		for (int i = 0; i < subjectavg.length; i++) {
			subjectavg[i] = (double) subjectsum[i] / student_size;
		}

		// ����� ����
		for (int i = 0; i < student_size; i++) {
			rank[i] = 1;// ��� �л� ���� 1�� �ʱ�ȭ
			for (int j = 0; j < student_size; j++) {
				if (sum[i] < sum[j]) {
					rank[i]++;
				}
			}
		}

		// ������ sort-��������
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

		// ���� �� �հ�, ��� , ���� console�� ǥ��
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
		// �����հ�
		System.out.print("�����հ�");
		for (int i = 0; i < subjectsum.length; i++) {
			System.out.print("\t" + subjectsum[i]);
		}
		System.out.println();

		// �������
		System.out.print("�������");
		for (int i = 0; i < subjectavg.length; i++) {
			System.out.printf("\t%.2f", subjectavg[i]);
		}
		System.out.println();

		System.out.println("-------------------------------------------------------------------------------------");
	}

}
