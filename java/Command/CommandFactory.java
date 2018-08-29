/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

/**
 *
 * @author
 */
public class CommandFactory {

    private volatile static CommandFactory currentInstance;

    private CommandFactory() {

    }

    public static CommandFactory getInstance() {
        if (currentInstance == null) {
            synchronized (CommandFactory.class) {
                if (currentInstance == null) {
                    currentInstance = new CommandFactory();
                }
            }
        }
        return currentInstance;
    }

    public static Command createCommand(String action) {
        Command command = null;
        if (action != null) {
            switch (action) {
                case "login":
                    command = new LoginCommand();
                    break;
                case "register":
                    command = new RegisterCommand();
                    break;
                case "search":
                    command = new SearchConditionCommand();
                    break;
                case "Search":
                    command = new SearchMedicinedCommand();
                    break;
                case "addmed":
                    command = new AddmedicineCommand();
                    break;
                case "addcondition":
                    command = new AddConditionCommand();
                    break;
                case "pill":
                    command = new AddPillCommand();
                    break;
              
                case "condEdit":
                    command = new UpdateConditionCommand();
                    break;
                case "changeLanguage":
                    command = new ChangeLanguageCommand();
                    break;

                case "medEdit":
                    command = new MedEditCommand();
                    break;

                case "shape":
                    command = new ShapeCommand();
                    break;
                case "upload":
                    command = new UploadPictureCommand();
                    break;
                case "communityTopics":
                    command = new CommunitiesCommand();
                    break;
                case "comment":
                    command = new MessageCommand();
                    break;
                case "contact":
                    command = new ContactCommand();
                    break;
                case "response":
                command = new ResponseCommand();
                break;
                default:
                    command = new NoValidActionCommand();
                    break;

            }
        } else {
            command = new NoActionSuppliedCommand();
        }
        return command;
    }

}
