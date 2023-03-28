package com.mysite.sbb.question;

import com.mysite.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mysite.sbb.DataNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    public Question getQuestion(Integer id){
        Optional<Question> question = this.questionRepository.findById(id);
        //Optional 클래스의 객체는 해당 값이 존재하는 경우, 값을 가지고 있으며 이를 .get() 메소드를 사용하여 가져올 수 있습니다. 그러나 값이 존재하지 않는 경우, 빈 Optional 객체를 반환합니다.
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }

    }
    public void create(String subject, String content, SiteUser user) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }
    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        //page는 조회할 페이지의 번호이고, 10은 한페이지에 보여줄 게시물 갯수
        return this.questionRepository.findAll(pageable);
    }
    public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }
    public void delete(Question question) {
        this.questionRepository.delete(question);
    }

}
