package shop.mtcoding.blogv2.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blogv2.user.UserRequest;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // ===========================================================================================

    // 고객센터 글목록 화면 호출
    @GetMapping("/board")
    public String board() {
        // 핵심로직 게시글 목록 검색

        return "board/board";
    }

    // ===========================================================================================

    // 게시글 글쓰기 화면 호출
    @GetMapping("/board/saveBoard")
    public String saveBoard() {

        return "board/saveBoard";
    }

    // 게시글 글쓰기 요청 응답
    @PostMapping("/board/save")
    public String save(BoardRequest.SaveDTO saveDTO, Integer sessionUserId) {
        boardService.글쓰기(saveDTO, 1);
        return "redirect:/board/";
    }
  
    // ===========================================================================================

    // 게시글 글수정,삭제 화면 호출
    @GetMapping("/board/updateForm")
    public String updateForm() {

        return "board/updateForm";
    }

    // 게시글 글수정,삭제 요청 응답
    @PostMapping("/board/{id}/update")
    public String update(@PathVariable Integer id, BoardRequest.UpdateDTO updateDTO) {
        boardService.게시글수정하기(id, updateDTO);
        return "redirect:/board/" + id;
    }

    // ===========================================================================================

    // 게시글 댓글 화면 호출 - 작성,삭제 post요청은 reply컨트롤러
    @GetMapping("/board/detailBoard")
    public String detailBoard() {

        return "board/detailBoard";
    }
    // ===========================================================================================

} // class
