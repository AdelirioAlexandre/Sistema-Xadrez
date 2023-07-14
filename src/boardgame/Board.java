package boardgame;
public class Board{
    private int rows;
    private int columns;
    private Piece[][] pieces;
    
    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Erro ao criar o tabuleiro, é necessario que haja ao menos uma linha e uma coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }
    
    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("Essa posição não existe no tabuleiro");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Essa posição não existe no tabuleiro");
        }
        return pieces[position.getRow()][position.getcolumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAìece(position)){
            throw new BoardException("Ja existe uma peça na posição " +position);
        }
        pieces[position.getRow()][position.getcolumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getcolumn());
    }

    public boolean thereIsAìece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Essa posição não existe no tabuleiro");
        }
        return piece(position) != null;
    }
}
