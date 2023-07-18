package chessPieces;
import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;
public class Rook extends ChessPiece {
    
    public Rook(Board board, Color color){
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMove() {
        boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p =new Position(0, 0);
        
        //Above
        p.setValues(position.getRow() -1, position.getcolumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAìece(p)){
            mat[p.getRow()][p.getcolumn()]  = true;
            p.setRow(p.getRow() -1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiee(p)){
            mat[p.getRow()][p.getcolumn()]  = true;
        }

        //Left
        p.setValues(position.getRow(), position.getcolumn() -1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAìece(p)){
            mat[p.getRow()][p.getcolumn()]  = true;
            p.setcolumn(p.getcolumn() -1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiee(p)){
            mat[p.getRow()][p.getcolumn()]  = true;
        }

        //Right
        p.setValues(position.getRow(), position.getcolumn() +1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAìece(p)){
            mat[p.getRow()][p.getcolumn()]  = true;
            p.setcolumn(p.getcolumn() +1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiee(p)){
            mat[p.getRow()][p.getcolumn()]  = true;
        }

        //Below
        p.setValues(position.getRow() +1, position.getcolumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAìece(p)){
            mat[p.getRow()][p.getcolumn()]  = true;
            p.setRow(p.getRow() +1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiee(p)){
            mat[p.getRow()][p.getcolumn()]  = true;
        }
        return mat;
    }
}