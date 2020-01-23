package announcements_simple_model;

import lombok.Getter;

@Getter
public enum ClothesSize {
	// enum class representing clothes sizes

	S(165, 86), M(170, 92), L(175, 98), XL(180, 104), XXL(185, 110);

	private int height, chestWidth;

	private ClothesSize(int height, int chestWidth) {
		this.height = height;
		this.chestWidth = chestWidth;
	}

	public void printSizeInfo(ClothesSize size) {
		switch (size) {
		case S:
			System.out.println("wzrost: 165cm, szerokość: 86cm");
			break;
		case M:
			System.out.println("wzrost: 170cm, szerokość: 92cm");
			break;
		case L:
			System.out.println("wzrost: 175cm, szerokość: 98cm");
			break;
		case XL:
			System.out.println("wzrost: 180cm, szerokość: 104cm");
			break;
		case XXL:
			System.out.println("wzrost: 185cm, szerokość: 110cm");
			break;
		}
	}

}
