package projectdjava2.pkg0;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Colin & Jeroen
 */
public class MazeSolver {

    private int waarde;
    private boolean draw = false;
    private Veld veld;
    private Speelbord speelbord;
    private Item item;
    private Item doel;

    public MazeSolver(int wrde, Veld vld, Speelbord splbord, Item itm, Item dl) {
        veld = vld;
        waarde = wrde;
        speelbord = splbord;
        item = itm;
        doel = dl;
    }

    public MazeSolver(Item itm, Item dl, Speelbord speelbord) {
        waarde = 0;
        item = itm;
        doel = dl;
        this.speelbord = speelbord;
        veld = item.getVeld();
        for (int j = 0; j < 20; j++) {
            for (int k = 0; k < 20; k++) {
                if (speelbord.getGrid(j, k).getMazeSolver(item) != null && speelbord.getGrid(j, k) != veld) {
                    speelbord.getGrid(j, k).dellMazeSolver(speelbord.getGrid(j, k).getMazeSolver(item));
                }
            }
        }
    }

    public void createNewMazeSolver() {
        String richting = "";
        if (veld.getItem() != doel) {
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    richting = "noord";
                } else if (i == 1) {
                    richting = "oost";
                } else if (i == 2) {
                    richting = "zuid";
                } else if (i == 3) {
                    richting = "west";
                }
                if (veld.getBuur(richting) != null) {
                    if (!(veld.getBuur(richting).getItem() instanceof Muur)) {
                        if (veld.getBuur(richting).getMazeSolver(item) == null || veld.getBuur(richting).getMazeSolver(item).getWaarde() > waarde + 1) {
                            MazeSolver mazeSolver1 = new MazeSolver(waarde + 1, veld.getBuur(richting), speelbord, item, doel);
                            veld.getBuur(richting).setMazeSolver(mazeSolver1);
                            mazeSolver1.createNewMazeSolver();

                        }
                    }
                }
            }
        } else {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 20; k++) {
                    if (speelbord.getGrid(j, k).getMazeSolver(item) != null) {
                        if (speelbord.getGrid(j, k).getMazeSolver(item).getDraw() == true) {
                            speelbord.getGrid(j, k).getMazeSolver(item).setDraw(false);
                        }
                    }
                }
            }
            if (doel instanceof Vriend) {
                this.solveMaze(waarde + 1);
            } else {
                this.getRichting(waarde + 1);
            }
        }
    }

    public void getRichting(int wrd) {
        if (wrd == waarde + 1) {
            draw = true;
            String richting = "";
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    richting = "noord";
                } else if (i == 1) {
                    richting = "oost";
                } else if (i == 2) {
                    richting = "zuid";
                } else if (i == 3) {
                    richting = "west";
                }
                if (veld.getBuur(richting) != null) {
                    if (veld.getBuur(richting).getItem() == item) {
                        item.loopRichting(richting);
                    } else if (veld.getBuur(richting).getMazeSolver(item) instanceof MazeSolver) {
                        MazeSolver mazeSolver0 = (MazeSolver) veld.getBuur(richting).getMazeSolver(item);
                        mazeSolver0.getRichting(waarde);
                    }
                }
            }
        }
    }

    public int getWaarde() {
        return waarde;
    }

    public Item getItem() {
        return item;
    }

    public void setVeld(Veld vel) {
        veld = vel;
    }

    public void setDraw(boolean dr) {
        draw = dr;
    }

    public Veld getVeld() {
        return veld;
    }

    public boolean getDraw() {
        return draw;
    }

    private void solveMaze(int wrd) {
        if (wrd == waarde + 1) {
            draw = true;
            String richting = "";
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    richting = "noord";
                }
                if (i == 1) {
                    richting = "oost";
                }
                if (i == 2) {
                    richting = "zuid";
                }
                if (i == 3) {
                    richting = "west";
                }
                if (veld.getBuur(richting) != null) {
                    if (veld.getBuur(richting).getMazeSolver(item) instanceof MazeSolver) {
                        MazeSolver mazeSolver0 = (MazeSolver) veld.getBuur(richting).getMazeSolver(item);
                        mazeSolver0.solveMaze(waarde);
                    }
                }
            }
        }
    }

    public void Teken(Graphics g) {
        if (draw == true) {
            g.setColor(Color.GREEN);
            g.fillRect((int) veld.getY() * 40, (int) veld.getX() * 40, 40, 40);
        }
    }
}
