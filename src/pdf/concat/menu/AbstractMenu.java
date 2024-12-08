package pdf.concat.menu;

import pdf.concat.Chooser;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class AbstractMenu implements Interactable {
    public void addToFrame(JButton function, JLabel warning, JLabel finish, JButton back, JLabel wrong,
                           JTextField field, JLabel title, JLabel wrongWarning) {
        Interactable.frame.add(function);
        Interactable.frame.add(back);
        Interactable.frame.add(warning);
        Interactable.frame.add(finish);
        Interactable.frame.add(field);
        Interactable.frame.add(title);
        Interactable.frame.add(wrong);
        Interactable.frame.add(wrongWarning);
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
    public void moveButtons(int count, Chooser outputChooser, JButton function, JLabel warning, JLabel finish,
                            JButton back, JLabel wrong, JButton add, JTextField field, JLabel wrongWarning,
                            List<Chooser> inputList) {
        if (inputList.size() > count) {
            add.setVisible(false);
        } else {
            add.setBounds(150, add.getBounds().y + 50, 220, 50);
            outputChooser.modifyChooser(25, outputChooser.getChooserButton().y + 50, 180,
                    outputChooser.getChooserField().y + 50);
            field.setBounds(50, field.getBounds().y + 50, 400, 30);
            function.setBounds(150, function.getBounds().y + 50, 220, 50);
            back.setBounds(150, back.getBounds().y + 50, 220, 50);
            warning.setBounds(100, warning.getBounds().y + 50, 600, 50);
            finish.setBounds(150, finish.getBounds().y + 50, 220, 50);
            wrong.setBounds(150, wrong.getBounds().y + 50, 600, 50);
            wrongWarning.setBounds(50, wrongWarning.getBounds().y + 50, 1000, 50);
        }
    }
    public void createInput(boolean type, Chooser inputChooser, JLabel warning, JLabel finish, JLabel wrong, JLabel wrongWarning,
                            List<Chooser> inputList) {
        Chooser input = new Chooser(Interactable.frame, true, warning, finish, wrong, wrongWarning);
        if (type) {
            if (inputList.isEmpty()) {
                input.createChooser(25, inputChooser.getChooserButton().y + 50, 180,
                        inputChooser.getChooserField().y + 50, "Choose PDF");
            } else {
                input.createChooser(25, inputList.getLast().getChooserButton().y + 50, 180,
                        inputList.getLast().getChooserField().y + 50, "Choose PDF");
            }
        } else {
            if (inputList.isEmpty()) {
                input.createChooser(25, inputChooser.getChooserButton().y + 50, 180,
                        inputChooser.getChooserField().y + 50, "Choose PDF 3");
            } else {
                input.createChooser(25, inputList.getLast().getChooserButton().y + 50, 180,
                        inputList.getLast().getChooserField().y + 50, "Choose PDF " + (inputList.size() + 3));
            }
        }
        inputList.add(input);
    }
    public void wrongWarningSetVisible(JLabel wrongWarning, JLabel finish, JLabel warning, JLabel wrong) {
        wrongWarning.setVisible(true);
        finish.setVisible(false);
        warning.setVisible(false);
        wrong.setVisible(false);
    }
    public void finishSetVisible(JLabel wrongWarning, JLabel finish, JLabel warning, JLabel wrong) {
        wrongWarning.setVisible(false);
        finish.setVisible(true);
        warning.setVisible(false);
        wrong.setVisible(false);
    }
    public void warningSetVisible(JLabel wrongWarning, JLabel finish, JLabel warning, JLabel wrong) {
        wrongWarning.setVisible(false);
        finish.setVisible(false);
        warning.setVisible(true);
        wrong.setVisible(false);
    }
    public void wrongSetVisible(JLabel wrongWarning, JLabel finish, JLabel warning, JLabel wrong) {
        wrongWarning.setVisible(false);
        finish.setVisible(false);
        warning.setVisible(false);
        wrong.setVisible(true);
    }
    public void setImportantBounds(boolean input, JButton function, JLabel warning, JLabel finish, JButton back,
                                   JLabel wrong, JTextField field, JLabel wrongWarning) {
        int addition = (input) ? 50 : 0;
        field.setBounds(50, 200 + addition, 400, 30);
        field.setToolTipText("Fill in name of the file");
        function.setBounds(150, 250 + addition, 220, 50);
        back.setBounds(150, 350 + addition, 220, 50);
        wrong.setBounds(150, 300 + addition, 600, 50);
        warning.setBounds(100, 300 + addition, 600, 50);
        wrongWarning.setBounds(50, 300 + addition, 1000, 50);
        finish.setBounds(150, 300 + addition, 220, 50);
        wrong.setForeground(Color.RED);
        warning.setForeground(Color.RED);
        wrongWarning.setForeground(Color.RED);
        finish.setVisible(false);
        warning.setVisible(false);
        wrong.setVisible(false);
        wrongWarning.setVisible(false);
    }
}