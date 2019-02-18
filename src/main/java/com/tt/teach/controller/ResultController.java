package com.tt.teach.controller;

import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.ResultService;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/res")
public class ResultController {

    @Resource
    private ResultService resultService;

    @RequestMapping("/result")
    public String result(Model model) {
        List<Subject> list = resultService.getSubjectAll();
        model.addAttribute("subjectList",list);
        return "/result/result";
    }

    @RequestMapping(value = "/findResAll",method = RequestMethod.GET)
    @ResponseBody
    public Object findResAll() {
        List<Result> list = resultService.findResAll();
        return list;
    }

    @RequestMapping(value = "/deleteResult/{resultNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteResult(@PathVariable Integer resultNo) {
        int result = resultService.deleteResult(resultNo);
        if (result>0){
            return JsonResult.ok("删除成功！",result);
        }
        return JsonResult.no("删除失败！",result);
    }
    @RequestMapping(value = "/updateResult",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateResult(@RequestParam Integer resultNo,@RequestParam Integer studentResult) {
        Result result2 = new Result();
        result2.setResultNo(resultNo);
        result2.setStudentResult(studentResult);
        int result = resultService.updateResult(result2);
        if (result>0){
            return JsonResult.ok("修改成功！",result);
        }
        return JsonResult.no("修改失败！",result);
    }

    @RequestMapping(value = "/addResult",method = RequestMethod.PUT)
    @ResponseBody
    public Object addResult(@RequestParam Integer subjectNo,@RequestParam Integer studentResult,@RequestParam String examDate,@RequestParam Integer studentNo) throws ParseException {
        Result result2 = new Result();
        result2.setSubjectNo(subjectNo);
        result2.setStudentResult(studentResult);
        result2.setStudentNo(studentNo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        result2.setExamDate(simpleDateFormat.parse(examDate));
        int result = resultService.addResult(result2);
        if (result>0){
            return JsonResult.ok("添加成功！",result);
        }
        return JsonResult.no("添加失败！",result);
    }

}
