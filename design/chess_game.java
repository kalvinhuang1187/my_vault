/*
Design a chess game
---
http://massivetechinterview.blogspot.com/2015/07/design-chess-game-using-oo-principles.html
UML Diagram: http://swcodes.blogspot.in/2012/09/chess-game-design.html
---
Board:
- A Board class has an attribute of Squares Array (8x8) and PieceSets (black and white).
- A Board class also has an attribute of "pieceSetOnTop". The attribute helps to figure the piece
moves that are direction-restricted.

PieceSets:
- A PieceSet class has an attribute of a List<Piece>. The size of the List<Piece> is initially set to 16.
- A Piece class has two attributes: color and placeAt (i.e. located at which square).
- A Piece class is an abstract class. The extended classes (Pawn, King, Queen, Rook, Knight, Bishop)
implements the abstracted operations:
    * validMoves() - The valid movement for a Piece
    * attackSquares() - The squares that a Piece can attack
    * captureFreeMove - The squares that a Piece can move to without being captured. 
    * toBeCaptured() - The boolean indicates whether a Piece is going to be captured.
- The validMoves() operation implements the movement rules. For example, the validMoves of a Pawn class
ensures that the Pawn can only move in the direction towards the opponent side. A Pawn class has additional
attributes of promoted and promotedTo, which describes the movement/conversion rule of a Pawn at reaching
the end of an opponent side and at the conversion about the piece that a Pawn converted to.

Game:
A Game class controls the flow of a game. The class has attributes:
    * playedMoves - Keep a record of moves
    * turn - Indicate either it is a Black's turn or a White's turn
    * players - Represent the two players, this can be Human/Human, Computer/Computer or Human/Computer
    * result - Indicate the result of a game
    * checkStatus - Indicate which side is being checked or checkmated

Player:
A Player class represents a Player. A Player has two attributes:
    * pieceColor - The color that used by a Player
    * engine - The engine that makes the moves. This can be a human or a computer 
*/

public enum PieceType {
    None, Pawn, Knight, Bishop, Rook, Queen, King
}

public enum PieceColor {
    White, Black
}

//black or white
public struct Piece {
    public PieceType Type { get; set; }
    public PieceColor Color { get; set; }
}

// square contains the position
public class Square {
    public int X { get; set; }
    public int Y { get; set; }
}

public class Board {
    private Square[8][8] squareSet;
    public Piece[][] pieceSet { get; set; }
    public Board Clone() { ... }
}

public class Move {
    public Square From { get; }
    public Square To { get; }
    public Piece PieceMoved { get; }
    public Piece PieceCaptured { get; }
    public PieceType Promotion { get; }
    public string AlgebraicNotation { get; }
}

public class Game {
    public Board Board { get; }
    public List<Move> Movelist { get; }
    public PieceType Turn { get; set; }
    public Square DoublePawnPush { get; set; } // Used for tracking valid en passant captures
    public int Halfmoves { get; set; }
    Player p1,p2;
    public bool CanWhiteCastleA { get; set; }
    public bool CanWhiteCastleH { get; set; }
    public bool CanBlackCastleA { get; set; }
    public bool CanBlackCastleH { get; set; }

     //methods
     private void createAndPlacePieces() {
         //generate pieces using a factory method
         //for e.g. config[1][0] = PieceFactory("Pawn",color);
     }

     private void setTurn(color) {
        turn = color;
        currentPlayer = (turn==black)?p2 : p1;
     }

     private void Play() {
         while(CheckStatus!=GameOver) {
            changeTurn(); // calls movePiece on the Piece object    
         }
     }
}



