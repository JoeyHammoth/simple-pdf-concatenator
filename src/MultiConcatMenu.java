import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MultiConcatMenu implements Interactable, MultiInteractable {
    private Chooser inputChooser1 = new Chooser(frame, true);
    private Chooser inputChooser2 = new Chooser(frame, true);
    private List<Chooser> inputList = new ArrayList<>();
    private Chooser folderChooser = new Chooser(frame, false);
    private JButton add = new JButton("+");
    private JButton con = new JButton("Concatenate PDF");
    private JLabel warning = new JLabel("Please choose at least two pdfs, a location and a name.");
    private JLabel finish = new JLabel("Concatenation completed.");
    private JButton back = new JButton("Go back");
    private JTextField field = new JTextField();
    private JLabel title = new JLabel("A Simple PDF Concatenator.");
    private MainMenu mainMenu;

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public MultiConcatMenu() {
        title.setBounds(150, 0, 220, 50);
        inputChooser1.createChooser(25, 50, 180, 50, "Choose PDF 1");
        inputChooser2.createChooser(25, 100, 180, 100, "Choose PDF 2");
        add.setBounds(150, 150, 220, 50);
        folderChooser.createChooser(25, 200, 180, 200, "Choose Folder");
        field.setBounds(50, 250, 400, 30);
        field.setToolTipText("Fill in the name of the file");
        con.setBounds(150, 300, 220, 50);
        back.setBounds(150, 400, 220, 50);
        warning.setBounds(100, 350, 600, 50);
        finish.setBounds(150, 350, 220, 50);
        warning.setForeground(Color.RED);
        finish.setVisible(false);
        warning.setVisible(false);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInput();
                moveButtons();
            }
        });

        con.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path1 = inputChooser1.getFilePath();
                String path2 = inputChooser2.getFilePath();
                List<String> list = new ArrayList<>();
                list.add(path1);
                list.add(path2);
                String outputPath = folderChooser.getFilePath();
                String name = field.getText();
                if (path1 == null || path2 == null || outputPath == null || name.isEmpty()) {
                    changeFieldColors(true);
                    finish.setVisible(false);
                    warning.setVisible(true);
                } else {
                    MultiConcat concat = new MultiConcat(list, outputPath, name);
                    try {
                        concat.concatenate();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    changeFieldColors(false);
                    warning.setVisible(false);
                    finish.setVisible(true);
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFieldColors(false);
                setVisibility(false);
                mainMenu.setVisibility(true);
            }
        });

        frame.add(con);
        frame.add(back);
        frame.add(warning);
        frame.add(finish);
        frame.add(field);
        frame.add(title);
        frame.add(add);
        setVisibility(false);
    }
    public void moveButtons() {
        if (inputList.size() > 5) {
            add.setVisible(false);
        } else {
            add.setBounds(150, add.getBounds().y + 50, 220, 50);
            folderChooser.modifyChooser(25, folderChooser.getChooserButton().y + 50, 180,
                    folderChooser.getChooserField().y + 50);
            field.setBounds(50, field.getBounds().y + 50, 400, 30);
            con.setBounds(150, con.getBounds().y + 50, 220, 50);
            back.setBounds(150, back.getBounds().y + 50, 220, 50);
            warning.setBounds(100, warning.getBounds().y + 50, 600, 50);
            finish.setBounds(150, finish.getBounds().y + 50, 220, 50);
        }
    }
    public void createInput() {
        Chooser input = new Chooser(frame, true);
        if (inputList.isEmpty()) {
            input.createChooser(25, inputChooser2.getChooserButton().y + 50, 180,
                    inputChooser2.getChooserField().y + 50, "Choose PDF 3");
        } else {
            input.createChooser(25, inputList.getLast().getChooserButton().y + 50, 180,
                    inputList.getLast().getChooserField().y + 50, "Choose PDF " + (inputList.size() + 3));
        }
        inputList.add(input);
    }

    public void setVisibility(boolean input) {
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
        }
    }

    public void changeFieldColors(boolean input) {
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
}
