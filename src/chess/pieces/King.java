package chess.pieces;
import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;
public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	private boolean canMove(Position position){
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		
		//Para Cima
		p.setValues(position.getRow() -1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumn()] = true;
		}

		//Para Baixo
		p.setValues(position.getRow() +1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumn()] = true;
		}

		//Para Esquerda
		p.setValues(position.getRow(), position.getColumn() -1);
		if(getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumn()] = true;
		}

		//Para direita
		p.setValues(position.getRow(), position.getColumn() +1);
		if(getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumn()] = true;
		}

		//Noroeste
		p.setValues(position.getRow() -1, position.getColumn() -1);
		if(getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumn()] = true;
		}

		//Sudeste
		p.setValues(position.getRow() +1, position.getColumn() +1);
		if(getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumn()] = true;
		}

		//Nordeste
		p.setValues(position.getRow() -1, position.getColumn() +1);
		if(getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumn()] = true;
		}

		//Sudoeste
		p.setValues(position.getRow() +1, position.getColumn() -1);
		if(getBoard().positionExists(p) && canMove(p)){
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}

	@Override
	public String toString() {
		return "K";
	}
}