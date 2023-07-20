package chess;
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
public abstract class ChessPiece extends Piece {

	private Color color;
	private int moveCaunt;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	public int getMoveCaunt(){
		return moveCaunt;
	}

	public void increaseMoveCCount(){
		moveCaunt++;
	}

	public void decreaseMoveCCount(){
		moveCaunt--;
	}

	public ChessPosition gChessPosition(){
		return ChessPosition.fromPosition(position);
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
}