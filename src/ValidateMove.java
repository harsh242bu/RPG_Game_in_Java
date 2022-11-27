import java.util.Set;

/**
 * check if the move is valid
 */
public class ValidateMove {

    public static boolean checkMapRange(Position position){
        int y = position.getY();
        int x = position.getX();
        if(y<0 || y>7 || x<0 || x>7){
            System.out.println("Cannot go out of map");
            return false;
        }
        return true;
    }
    public static boolean checkInaccessible(Position position){
//        System.out.println(position);
        int y = position.getY();
        if( y==2 || y==5){
            System.out.println("Cannot go through the wall");
            return false;
        }
        return true;
    }
    
    public static boolean checkPassingMonster(Position position){
        Set<Position> positions = CharacterLocation.getmonsterLocation();
        for (Position i:positions){
            if (position.equals(i) || (Math.abs(position.getY()-i.getY())==1 && position.getX()==i.getX())){
                System.out.println("Cannot pass a monster");
                return false;
            }
        }
        return true;

    }

    public static boolean checkDuplicateHero(Position position){
        Set<Position> positions = CharacterLocation.getheroLocation();
        for(Position i: positions){
            if(position.equals(i)){

                return false;
            }
        }
        return true;
    }

}
