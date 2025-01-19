package pdf.concat.menu;

import pdf.concat.Chooser;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Abstract class that contains methods that are used in all menu classes.
 * It contains methods that are used to add buttons to the frame, set their visibility, change field colors,
 * check if the type is correct, move buttons, create input, set warnings visible and set important bounds.
 */
public abstract class AbstractMenu implements Interactable {

    /**
     * Adds text to the frame.
     * @param function JButton that is used to perform the function.
     * @param warning JLabel that is used to display warning.
     * @param finish JLabel that is used to display finish message.
     * @param back JButton that is used to go back to the main menu.
     * @param wrong JLabel that is used to display wrong message.
     * @param field JTextField that is used to get the name of the file.
     * @param title JLabel that is used to display the title of the function.
     * @param wrongWarning JLabel that is used to display wrong warning.
     */
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

    /**
     * Changes the visibility of the components for MultiReverse Menu.
     * If input is true, it sets the visibility of the input components to true and the rest to false.
     * If input is false, it sets the visibility of the input components to false and the rest to false.
     * @param input boolean that determines if the input components should be visible.
     * @param inputChooser Chooser that is used to choose the input file.
     * @param outputChooser Chooser that is used to choose the output file.
     * @param rev JButton that is used to reverse the order of the input files.
     * @param warning JLabel that is used to display warning.
     * @param finish JLabel that is used to display finish message.
     * @param back JButton that is used to go back to the main menu.
     * @param wrong JLabel that is used to display wrong message.
     * @param add JButton that is used to add more input files.
     * @param field JTextField that is used to get the name of the file.
     * @param title JLabel that is used to display the title of the function.
     * @param wrongWarning JLabel that is used to display wrong warning.
     * @param inputList List of Choosers that are used to choose the input files.
     */
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

    /**
     * Changes the visibility of the components for MultiConcat Menu.
     * If input is true, it sets the visibility of the input components to true and the rest to false.
     * If input is false, it sets the visibility of the input components to false and the rest to false.
     * @param input boolean that determines if the input components should be visible.
     * @param inputChooser1 Chooser that is used to choose the input file.
     * @param inputChooser2 Chooser that is used to choose the input file.
     * @param warning JLabel that is used to display warning.
     * @param finish JLabel that is used to display finish message.
     * @param back JButton that is used to go back to the main menu.
     * @param wrong JLabel that is used to display wrong message.
     * @param add JButton that is used to add more input files.
     * @param field JTextField that is used to get the name of the file.
     * @param title JLabel that is used to display the title of the function.
     * @param wrongWarning JLabel that is used to display wrong warning.
     * @param inputList List of Choosers that are used to choose the input files.
     * @param folderChooser Chooser that is used to choose the folder where the output file will be saved.
     * @param con JButton that is used to concatenate the input files.
     */
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

    /**
     * Changes the visibility of the components for MultiMerge Menu.
     * If input is true, it sets the visibility of the input components to true and the rest to false.
     * If input is false, it sets the visibility of the input components to false and the rest to false.
     * @param input boolean that determines if the input components should be visible.
     * @param inputChooser1 Chooser that is used to choose the input file.
     * @param inputChooser2 Chooser that is used to choose the input file.
     * @param folderChooser Chooser that is used to choose the folder where the output file will be saved.
     * @param merge JButton that is used to merge the input files.
     * @param warning JLabel that is used to display warning.
     * @param finish JLabel that is used to display finish message.
     * @param back JButton that is used to go back to the main menu.
     * @param wrong JLabel that is used to display wrong message.
     * @param field JTextField that is used to get the name of the file.
     * @param title JLabel that is used to display the title of the function.
     * @param wrongWarning JLabel that is used to display wrong warning.
     */
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

    /**
     * Changes the field colors based on the input boolean.
     * If input is true, it changes the colors of the inputChooser and outputChooser to red and the field to red.
     * If input is false, it changes the colors of the inputList, inputChooser and outputChooser
     * to white and the field to white.
     *
     * @param input boolean that determines if the colors should be changed to red.
     * @param inputChooser Chooser that is used to choose the input file.
     * @param outputChooser Chooser that is used to choose the output file.
     * @param field JTextField that is used to get the name of the file.
     * @param inputList List of Choosers that are used to choose the input files.
     */
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

    /**
     * Changes the field colors based on the input boolean.
     * If input is true, it changes the colors of the inputChooser1, inputChooser2 and folderChooser to red
     * and the field to red.
     * If input is false, it changes the colors of the inputList, inputChooser1, inputChooser2 and folderChooser
     * to white and the field to white.
     *
     * @param input boolean that determines if the colors should be changed to red.
     * @param inputChooser1 Chooser that is used to choose the input file.
     * @param inputChooser2 Chooser that is used to choose the input file.
     * @param folderChooser Chooser that is used to choose the folder where the output file will be saved.
     * @param field JTextField that is used to get the name of the file.
     * @param inputList List of Choosers that are used to choose the input files.
     */
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

    /**
     * Changes the field colors based on the input boolean.
     * If input is true, it changes the colors of the inputChooser1, inputChooser2 and folderChooser to red
     * and the field to red.
     * If input is false, it changes the colors of the inputChooser1, inputChooser2 and folderChooser
     * to white and the field to white.
     *
     * @param input boolean that determines if the colors should be changed to red.
     * @param inputChooser1 Chooser that is used to choose the input file.
     * @param inputChooser2 Chooser that is used to choose the input file.
     * @param folderChooser Chooser that is used to choose the folder where the output file will be saved.
     * @param field JTextField that is used to get the name of the file.
     */
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

    /**
     * Check if fields are filled. If they are not, change their colors to red and return true.
     * If they are filled, return false. Used for MultiReverse Menu.
     * @param inputChooser1 Chooser that is used to choose the input file.
     * @param inputChooser2 Chooser that is used to choose the input file.
     * @return boolean that determines if the fields are filled.
     */
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

    /**
     * Check if fields are filled. If they are not, change their colors to red and return true.
     * If they are filled, return false. Used for MultiConcat Menu.
     * @param inputChooser Chooser that is used to choose the input file.
     * @param inputList List of Choosers that are used to choose the input files.
     * @return boolean that determines if the fields are filled.
     */
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

    /**
     * Check if fields are filled. If they are not, change their colors to red and return true.
     * If they are filled, return false. Used for MultiMerge Menu.
     * @param inputChooser1 Chooser that is used to choose the input file.
     * @param inputChooser2 Chooser that is used to choose the input file.
     * @param inputList List of Choosers that are used to choose the input files.
     * @return boolean that determines if the fields are filled.
     */
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

    /**
     * Moves the buttons and fields based on the count of the inputList.
     * If the inputList size is greater than the count, it sets the add button to invisible.
     * If the inputList size is less than the count, it moves the buttons and fields down.
     * Used for MultiConcat Menu.
     *
     * @param count int that determines the number of input files that can be added.
     * @param outputChooser Chooser that is used to choose the output file.
     * @param function JButton that is used to perform the function.
     * @param warning JLabel that is used to display warning.
     * @param finish JLabel that is used to display finish message.
     * @param back JButton that is used to go back to the main menu.
     * @param wrong JLabel that is used to display wrong message.
     * @param add JButton that is used to add more input files.
     * @param field JTextField that is used to get the name of the file.
     * @param wrongWarning JLabel that is used to display wrong warning.
     * @param inputList List of Choosers that are used to choose the input files.
     */
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

    /**
     * Create PDF Chooser based on the type boolean. If type is true, it creates the first inputChooser.
     * If type is false, it creates the inputChooser after the last inputChooser in the inputList.
     *
     * @param type boolean that determines if the inputChooser is the first one.
     * @param inputChooser Chooser that is used to choose the input file.
     * @param warning JLabel that is used to display warning.
     * @param finish JLabel that is used to display finish message.
     * @param wrong JLabel that is used to display wrong message.
     * @param wrongWarning JLabel that is used to display wrong warning.
     * @param inputList List of Choosers that are used to choose the input files.
     */
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

    /**
     * Set the visibility of the warnings based on the input boolean. If input is true, it sets the wrongWarning
     * to visible and the rest to invisible. If input is false, it sets the wrongWarning to invisible.
     *
     * @param wrongWarning JLabel that is used to display wrong warning.
     * @param finish JLabel that is used to display finish message.
     * @param warning JLabel that is used to display warning.
     * @param wrong JLabel that is used to display wrong message.
     */
    public void wrongWarningSetVisible(JLabel wrongWarning, JLabel finish, JLabel warning, JLabel wrong) {
        wrongWarning.setVisible(true);
        finish.setVisible(false);
        warning.setVisible(false);
        wrong.setVisible(false);
    }

    /**
     * Set the visibility of the finish message based on the input boolean. If input is true, it sets the finish
     * to visible and the rest to invisible. If input is false, it sets the finish to invisible.
     *
     * @param wrongWarning JLabel that is used to display wrong warning.
     * @param finish JLabel that is used to display finish message.
     * @param warning JLabel that is used to display warning.
     * @param wrong JLabel that is used to display wrong message.
     */
    public void finishSetVisible(JLabel wrongWarning, JLabel finish, JLabel warning, JLabel wrong) {
        wrongWarning.setVisible(false);
        finish.setVisible(true);
        warning.setVisible(false);
        wrong.setVisible(false);
    }

    /**
     * Set the visibility of the warning message based on the input boolean. If input is true, it sets the warning
     * to visible and the rest to invisible. If input is false, it sets the warning to invisible.
     *
     * @param wrongWarning JLabel that is used to display wrong warning.
     * @param finish JLabel that is used to display finish message.
     * @param warning JLabel that is used to display warning.
     * @param wrong JLabel that is used to display wrong message.
     */
    public void warningSetVisible(JLabel wrongWarning, JLabel finish, JLabel warning, JLabel wrong) {
        wrongWarning.setVisible(false);
        finish.setVisible(false);
        warning.setVisible(true);
        wrong.setVisible(false);
    }

    /**
     * Set the visibility of the wrong message based on the input boolean. If input is true, it sets the wrong
     * to visible and the rest to invisible. If input is false, it sets the wrong to invisible.
     *
     * @param wrongWarning JLabel that is used to display wrong warning.
     * @param finish JLabel that is used to display finish message.
     * @param warning JLabel that is used to display warning.
     * @param wrong JLabel that is used to display wrong message.
     */
    public void wrongSetVisible(JLabel wrongWarning, JLabel finish, JLabel warning, JLabel wrong) {
        wrongWarning.setVisible(false);
        finish.setVisible(false);
        warning.setVisible(false);
        wrong.setVisible(true);
    }

    /**
     * Set the bounds of the components based on the input boolean. If input is true, it sets the bounds of the
     * components to the important bounds. If input is false, it sets the bounds of the components to the normal bounds.
     *
     * @param input boolean that determines if the bounds should be set to the important bounds.
     * @param function JButton that is used to perform the function.
     * @param warning JLabel that is used to display warning.
     * @param finish JLabel that is used to display finish message.
     * @param back JButton that is used to go back to the main menu.
     * @param wrong JLabel that is used to display wrong message.
     * @param field JTextField that is used to get the name of the file.
     * @param wrongWarning JLabel that is used to display wrong warning.
     */
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