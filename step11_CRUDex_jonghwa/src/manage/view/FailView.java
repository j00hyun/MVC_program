/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  FailView.java
 * DESC  : 예외 발생시 예외 메세지 처리 로직의 전담 클래스
 * 
 * @author  
 * @version 1.0
*/

package manage.view;

public class FailView {
	public static void failMessageView(String message) {
		System.out.println("발생된 예외상황 : " + message);
	}
}
