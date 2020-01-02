package Service.Qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Command.Qna.QnaAnswerReplyCommand;
import Model.DTO.QnaDTO;
import Repository.Qna.QnaRepository;

@Service
public class QanAnswerService {

	@Autowired
	QnaRepository qnaRepository;
	
	public void qnaAnswer(Long qnaBoardNum, Model model) {
		
		QnaDTO qna = new QnaDTO();
		
			qna = qnaRepository.oneSelect(qnaBoardNum);
		System.out.println();
		
		QnaAnswerReplyCommand qnaAnswerReplyCommand = new QnaAnswerReplyCommand();
		
		
		qnaAnswerReplyCommand.getQnaCommand().setQnaSubject("Re:" + qna.getQnaBoardSubject());
		qnaAnswerReplyCommand.getQnaCommand().setQnaClassiFication(qna.getQnaClassiFication());
		qnaAnswerReplyCommand.setQnaBoardNum(qna.getQnaBoardNum().toString());
		System.out.println(qna.getQnaBoardReLev());
		qnaAnswerReplyCommand.setQnaBoardReLev(qna.getQnaBoardReLev().toString());
		qnaAnswerReplyCommand.setQnaBoardReRef(qna.getQnaBoardReRef().toString());
		qnaAnswerReplyCommand.setQnaBoardReSeq(qna.getQnaBoardReSeq().toString());
		model.addAttribute("qnaAnswerReplyCommand",qnaAnswerReplyCommand);
		
		
	}
}
