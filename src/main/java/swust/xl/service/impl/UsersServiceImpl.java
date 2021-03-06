package swust.xl.service.impl;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import swust.xl.dao.Mappers;
import swust.xl.mailservice.MailService;
import swust.xl.pojo.bo.adduser.request.BoAddUserRequest;
import swust.xl.pojo.bo.getuser.response.BoGetUserResponse;
import swust.xl.pojo.bo.patchuser.request.BoPatchUserRequest;
import swust.xl.pojo.dto.BoMapper;
import swust.xl.pojo.vo.UserLogin;
import swust.xl.pojo.vo.VerificationCodeResp;
import swust.xl.service.UsersService;
import swust.xl.util.image.VerifyImageUtil;

/**
 * 
 * 用户信息操作相关服务层实现.
 *
 * @author xuLiang
 * @since 0.0.1
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private Mappers mappers;
	@Autowired
	private MailService mailservice;

	/**
	 * 
	 * 获取一条用户信息记录.
	 *
	 * @param id
	 *            待获取用户id
	 * @return 一条得到的用户信息记录
	 * @author xuLiang
	 * @since 0.0.1
	 */
	@Override
	public BoGetUserResponse getUser(Long id) {
		return BoMapper.INSTANCE.toBoGetUserRespMap(mappers.getUser(id));

	}

	/**
	 * 
	 * 添加一条用户信息记录.
	 *
	 * @param boAddUserRequest
	 *            待添加的用户信息
	 * @return 添加完成的用户信息对象
	 * @author xuLiang
	 * @since 0.0.1
	 */
	@Transactional
	@Override
	public BoGetUserResponse addUser(BoAddUserRequest boAddUserRequest) {
		// 注册成功邮件发送功能实现
		mailservice.sendSimpleMail(boAddUserRequest.getEmail(), "此处为邮件主题", "此处为邮件正文");
		return BoMapper.INSTANCE
				.toBoGetUserRespMap(mappers.addUser(BoMapper.INSTANCE.fromBoAddUserReqMap(boAddUserRequest)));
	}

	/**
	 * 
	 * 删除一条用户信息记录.
	 *
	 * @param id
	 *            待删除的用户信息id
	 * @return 删除结果：true-删除成功，成功删除一条用户记录；false-删除失败，没有删除任何记录
	 * @author xuLiang
	 * @since 0.0.1
	 */
	@Transactional
	@Override
	public boolean deleteUser(Long id) {
		return mappers.deleteUser(id);
	}

	/**
	 * 
	 * 更新一个用户信息记录.
	 * 
	 * @param userPerson
	 *            需要更新的用户对象
	 * 
	 * @return 更新后的用户对象
	 * @author xuLiang
	 * @since 0.0.1
	 */
	@Transactional
	@Override
	public BoGetUserResponse patchUser(BoPatchUserRequest boPatchUserRequest) {
		return BoMapper.INSTANCE
				.toBoGetUserRespMap(mappers.patchUser(BoMapper.INSTANCE.fromBoPatchUserReqMap(boPatchUserRequest)));
	}

	/**
	 * 
	 * 验证用户登陆
	 * 
	 * @param userLogin
	 *            用户登陆请求体
	 * @return true ， false
	 * @author xuLiang
	 * @since 0.0.1
	 */
	@Override
	public boolean verifyLogin(UserLogin userLogin) {
		return mappers.findByIdAndPassword(userLogin);
	}

	/**
	 * 获取图片和坐标值
	 * 
	 * @param originImgX
	 *            原图的长
	 * @param originImgY
	 *            原图的宽
	 * @param cuttedImgX
	 *            裁出来的方块的长
	 * @param cuttedImgY
	 *            裁出来的方块的宽
	 * @param path
	 *            原图文件路径
	 * @return VerificationCodeResp
	 * @author xuLiang
	 * @since 0.0.1
	 * @throws Exception
	 */
	@Override
	public VerificationCodeResp getImage(int originImgX, int originImgY, int cuttedImgX, int cuttedImgY, String path)
			throws Exception {
		int x = new Random().nextInt(originImgX - cuttedImgX);
		int y = new Random().nextInt(originImgY - cuttedImgY);
		BufferedImage bufferedImage = ImageIO.read(new FileInputStream(path));
		VerifyImageUtil verifyImageUtil = new VerifyImageUtil();
		BufferedImage cuttedImg = verifyImageUtil.getMarkImage(bufferedImage, x, y, cuttedImgX, cuttedImgY);// 用来裁剪到滑动的方块
		int[][] cuttedOriginImgCoordinate = verifyImageUtil.getCutAreaData(originImgX, originImgY, x, y, cuttedImgX,
				cuttedImgY);// 被抠滑块的坐标
		VerifyImageUtil.cutByTemplate(bufferedImage, cuttedOriginImgCoordinate);// 得到抠掉滑块后的图并加阴影
		VerificationCodeResp response = new VerificationCodeResp();
		response.setCuttedImgBase64(verifyImageUtil.imageToBase64(cuttedImg));
		response.setCuttedOriginImgBase64(verifyImageUtil.imageToBase64(bufferedImage));
		response.setXCoordinate(x + "");
		response.setYCoordinate(y + "");
		return response;
	}

}
