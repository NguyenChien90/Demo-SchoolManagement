package ra.service.user;

import ra.constant.FileName;
import ra.model.User;
import ra.repo.FileRepository;

import java.util.List;

public class UserServiceIMPL implements IUserService {
    FileRepository<User, Integer> userRepository;
    FileRepository<User, Integer> loginRepository;

    public UserServiceIMPL() {
        this.userRepository = new FileRepository<>(FileName.USER);
        this.loginRepository = new FileRepository<>(FileName.LOGIN);
    }

    //for testing
    public UserServiceIMPL(String fileName) {
        this.userRepository = new FileRepository<>(fileName);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public int getNewId() {
        return userRepository.getNewId();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByID(int id) {
        return userRepository.findById(id);
    }

    public User login(String username, String password) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loginRepository.saveOnlyOne(user);
                return user;
            }
        }

        return null;
    }

    public User getCurrentUser() {
        return loginRepository.getOne();
    }
}
