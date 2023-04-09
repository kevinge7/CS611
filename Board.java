import java.util.Arrays;
import java.util.Random;




    public class Board {

        public static void main(String[] args) {
            Board b = new Board();
            b.display();

        }


        protected int size;


        private Cell[][] status;

        public Board(){
            // construct a new board
            this.size = 8;
            this.status = generate();
        }

        public Cell[][] generate(){
            Cell[][] sample = new Cell[this.size][this.size];
            CellFactory cellFactory = new CellFactory();

            Random random = new Random();

            for (int i = 0; i < this.size; i++){
                for (int j = 0; j < this.size; j++){
                    if ( i == 2 || i== 5){
                        sample[i][j] = cellFactory.create(5);
                    }else{
                        if (j == 0 || j == 7){
                            sample[i][j] = cellFactory.create(6);

                        }else {
                            int randomNumber = random.nextInt(4) + 1;
                            sample[i][j] = cellFactory.create(randomNumber);
                        }
                    }
                }
            }
            return sample;
        }

        public int getSize() {
            return size;
        }

        public Cell[][] getStatus(){
            return this.status;
        }
        public void display(){
            for (int j = this.size - 1;j >=0;j--) {
                for (int i = 0; i < this.size; i++) {
                    Cell currentCell = this.status[i][j];
                    char letter = currentCell.getLetter();

                    String line = " " + letter + " - " + letter + " - " + letter + " ";
                    System.out.print(line);
                }
                System.out.println();
                for (int i = 0; i < this.size; i++) {
                    Cell currentCell = this.status[i][j];
                    char letter = currentCell.getLetter();
                    String info = currentCell.getCurrentInfo();
                    System.out.print(" | " + info + " | ");
                }
                System.out.println();
                for (int i = 0; i < this.size; i++) {
                    Cell currentCell = this.status[i][j];
                    char letter = currentCell.getLetter();
                    String line = " " + letter + " - " + letter + " - " + letter + " ";
                    System.out.print(line);
                }
                System.out.println();
                for (int i = 0; i < this.size; i++) {
                    System.out.print("           ");
                }
                System.out.println();
            }
        }

    }


