package govhs.apsc.week22;

public class TestScoresApp{

   public static void main(String[] args){
      TestScoresModel model= new TestScoresModel();
      new TestScoresView(model);
   }
}