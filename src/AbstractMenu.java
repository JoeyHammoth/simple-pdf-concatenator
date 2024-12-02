import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu implements Interactable {
    public void addToFrame(JButton function, JLabel warning, JLabel finish, JButton back, JLabel wrong,
                           JTextField field, JLabel title, JLabel wrongWarning) {
        frame.add(function);
        frame.add(back);
        frame.add(warning);
        frame.add(finish);
        frame.add(field);
        frame.add(title);
        frame.add(wrong);
        frame.add(wrongWarning);
    }
    public void setVisibility(boolean input, Chooser inputChooser, Chooser outputChooser,
                              JButton rev, JLabel warning, JLabel finish, JButton back, JLabel wrong, JButton add,
                              JTextField field, JLabel title, JLabel wrongWarning, List<Chooser> inputList) {
        if (input) {
            inputChooser.setVisibility(true);
            for (Chooser chooser : inputList) {
                chooser.setVisibility(true);
            }
            outputChooser.setVisibility(true);
            rev.setVisible(true);
            back.setVisible(true);
            field.setVisible(true);
            title.setVisible(true);
            add.setVisible(inputList.size() <= 6);
        } else {
            inputChooser.setVisibility(false);
            for (Chooser chooser : inputList) {
                chooser.setVisibility(false);
            }
            outputChooser.setVisibility(false);
            add.setVisible(false);
            rev.setVisible(false);
            warning.setVisible(false);
            finish.setVisible(false);
            back.setVisible(false);
            field.setVisible(false);
            title.setVisible(false);
            wrong.setVisible(false);
            wrongWarning.setVisible(false);
        }
    }
    public void setVisibility(boolean input, Chooser inputChooser1, Chooser inputChooser2, Chooser folderChooser,
                              JButton con, JLabel warning, JLabel finish, JButton back, JLabel wrong, JButton add,
                              JTextField field, JLabel title, JLabel wrongWarning, List<Chooser> inputList) {
        if (input) {
            inputChooser1.setVisibility(true);
            inputChooser2.setVisibility(true);
            for (Chooser chooser : inputList) {
                chooser.setVisibility(true);
            }
            folderChooser.setVisibility(true);
            con.setVisible(true);
            back.setVisible(true);
            field.setVisible(true);
            title.setVisible(true);
            add.setVisible(inputList.size() <= 5);
        } else {
            inputChooser1.setVisibility(false);
            inputChooser2.setVisibility(false);
            for (Chooser chooser : inputList) {
                chooser.setVisibility(false);
            }
            folderChooser.setVisibility(false);
            add.setVisible(false);
            con.setVisible(false);
            warning.setVisible(false);
            finish.setVisible(false);
            back.setVisible(false);
            field.setVisible(false);
            title.setVisible(false);
            wrong.setVisible(false);
            wrongWarning.setVisible(false);
        }
    }
    public void setVisibility(boolean input, Chooser inputChooser1, Chooser inputChooser2, Chooser folderChooser,
                              JButton merge, JLabel warning, JLabel finish, JButton back, JLabel wrong,
                              JTextField field, JLabel title, JLabel wrongWarning) {
        if (input) {
            inputChooser1.setVisibility(true);
            inputChooser2.setVisibility(true);
            folderChooser.setVisibility(true);
            merge.setVisible(true);
            back.setVisible(true);
            field.setVisible(true);
            title.setVisible(true);
        } else {
            inputChooser1.setVisibility(false);
            inputChooser2.setVisibility(false);
            folderChooser.setVisibility(false);
            merge.setVisible(false);
            warning.setVisible(false);
            finish.setVisible(false);
            back.setVisible(false);
            field.setVisible(false);
            title.setVisible(false);
            wrong.setVisible(false);
            wrongWarning.setVisible(false);
        }
    }
    public void changeFieldColors(boolean input, Chooser inputChooser, Chooser outputChooser,
                                  JTextField field, List<Chooser> inputList) {
        if (input) {
            inputChooser.changeColors(true);
            outputChooser.changeColors(true);
            field.setBackground(Color.RED);
        } else {
            for (Chooser chooser : inputList) {
                chooser.changeColors(false);
            }
            inputChooser.changeColors(false);
            outputChooser.changeColors(false);
            field.setBackground(Color.WHITE);
        }
    }
    public void changeFieldColors(boolean input, Chooser inputChooser1, Chooser inputChooser2, Chooser folderChooser,
                                  JTextField field, List<Chooser> inputList) {
        if (input) {
            inputChooser1.changeColors(true);
            inputChooser2.changeColors(true);
            folderChooser.changeColors(true);
            field.setBackground(Color.RED);
        } else {
            for (Chooser chooser : inputList) {
                chooser.changeColors(false);
            }
            inputChooser1.changeColors(false);
            inputChooser2.changeColors(false);
            folderChooser.changeColors(false);
            field.setBackground(Color.WHITE);
        }
    }
    public void changeFieldColors(boolean input, Chooser inputChooser1, Chooser inputChooser2, Chooser folderChooser,
                                  JTextField field) {
        if (input) {
            inputChooser1.changeColors(true);
            inputChooser2.changeColors(true);
            folderChooser.changeColors(true);
            field.setBackground(Color.RED);
        } else {
            inputChooser1.changeColors(false);
            inputChooser2.changeColors(false);
            folderChooser.changeColors(false);
            field.setBackground(Color.WHITE);
        }
    }
    public boolean checkType(Chooser inputChooser1, Chooser inputChooser2) {
        boolean isWrong = false;
        if (!inputChooser1.getFilled()) {
            inputChooser1.changeColors(true);
            isWrong = true;
        }
        if (!inputChooser2.getFilled()) {
            inputChooser2.changeColors(true);
            isWrong = true;
        }
        return isWrong;
    }
    public boolean checkType(Chooser inputChooser, List<Chooser> inputList) {
        boolean isWrong = false;
        if (!inputChooser.getFilled()) {
            inputChooser.changeColors(true);
            isWrong = true;
        }
        for (Chooser chooser : inputList) {
            if (!chooser.getFilled()) {
                chooser.changeColors(true);
                isWrong = true;
            }
        }
        return isWrong;
    }
    public boolean checkType(Chooser inputChooser1, Chooser inputChooser2, List<Chooser> inputList) {
        boolean isWrong = false;
        if (!inputChooser1.getFilled()) {
            inputChooser1.changeColors(true);
            isWrong = true;
        }
        if (!inputChooser2.getFilled()) {
            inputChooser2.changeColors(true);
            isWrong = true;
        }
        for (Chooser chooser : inputList) {
            if (!chooser.getFilled()) {
                chooser.changeColors(true);
                isWrong = true;
            }
        }
        return isWrong;
    }

}
