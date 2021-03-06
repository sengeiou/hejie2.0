package ajax.model.taobao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import ajax.model.FormComponents;
import ajax.model.ItemStatus;
import ajax.model.annotations.FormComponentAnno;
import ajax.model.annotations.FormComponentUrlAnno;
import ajax.model.entity.Entity;
import ajax.tools.Tools;

@FormComponentUrlAnno(submitUrl="/admin/tbkitems/submit")
public class TbkItem extends Entity<TbkItem>{
	class SmallImages{
		private List<String> string;

		public List<String> getString() {
			return string;
		}
		public void setString(List<String> string) {
			this.string = string;
		}
	}
	
	@FormComponentAnno(desc="序号", isHidden=true)
	private long num_iid;
	@FormComponentAnno(desc="标题")
	private String title;
	@FormComponentAnno(desc="封面图片", componentType=FormComponents.ComponentType.IMAGE)
	private String pict_url;
	@FormComponentAnno(isDiscard=true)
	private SmallImages small_images;
	@FormComponentAnno(isHidden=true)
	private String small_images_string;
	@FormComponentAnno(desc="商品一口价格", isDisabled=true)
	private String reserve_price;
	@FormComponentAnno(desc="商品折扣价格", isDisabled=true)
	private String zk_final_price;
	@FormComponentAnno(isHidden=true)
	private long user_type;
	@FormComponentAnno(desc="宝贝所在地", isDisabled=true)
	private String provcity;
	@FormComponentAnno(desc="商品链接", componentType=FormComponents.ComponentType.LINK)
	private String item_url;
	@FormComponentAnno(desc="卖家昵称", isDisabled=true)
	private String nick;
	@FormComponentAnno(isDiscard=true)
	private long seller_id;
	@FormComponentAnno(desc="30天内交易量(Tip:根据销售量可以判断该商品是否容易转化)", isDisabled=true)
	private long volume;
	@FormComponentAnno(desc="二货君收集的日期", isDisabled=true, componentType=FormComponents.ComponentType.DATE)
	private String dateEntered = null;
	@FormComponentAnno(desc="简要描述(120字左右),如果不写,系统将默认截取内容的前120字", componentType=FormComponents.ComponentType.TEXTAREA)
	private String description = "";
	@FormComponentAnno(desc="编辑内容", componentType=FormComponents.ComponentType.UEDITOR)
	private String content = "";
	
	/**
	 * 商品ID
	 * @return
	 */
	public long getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(long num_iid) {
		this.num_iid = num_iid;
	}
	/**
	 * 商品标题
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 商品主图
	 * @return
	 */
	public String getPict_url() {
		return pict_url;
	}
	public void setPict_url(String pict_url) {
		this.pict_url = pict_url;
	}
	/**
	 * 商品小图列表
	 * @return
	 */
	public SmallImages getSmall_images() {
		if (small_images.getString().size() == 0 && !this.small_images_string.equals("")) {
			this.small_images = this.changeStringToSmallImages(this.small_images_string);
		}
		return small_images;
	}
	public void setSmall_images(SmallImages small_images) {
		this.small_images = small_images;
	}

	public String getSmall_images_string() {
		return small_images_string;
	}
	public void setSmall_images_string(String small_images_string) {
		this.small_images_string = small_images_string;
	}
	/**
	 * 商品一口价格
	 * @return
	 */
	public String getReserve_price() {
		return reserve_price;
	}
	public void setReserve_price(String reserve_price) {
		this.reserve_price = reserve_price;
	}
	/**
	 * 商品折扣价格
	 * @return
	 */
	public String getZk_final_price() {
		return zk_final_price;
	}
	public void setZk_final_price(String zk_final_price) {
		this.zk_final_price = zk_final_price;
	}
	/**
	 * 卖家类型，0表示集市，1表示商城
	 * @return
	 */
	public long getUser_type() {
		return user_type;
	}
	public void setUser_type(long user_type) {
		this.user_type = user_type;
	}
	/**
	 * 宝贝所在地
	 * @return
	 */
	public String getProvcity() {
		return provcity;
	}
	public void setProvcity(String provcity) {
		this.provcity = provcity;
	}
	/**
	 * 商品地址
	 * @return
	 */
	public String getItem_url() {
		return item_url;
	}
	public void setItem_url(String item_url) {
		this.item_url = item_url;
	}
	/**
	 * 卖家昵称
	 * @return
	 */
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	/**
	 * 卖家id
	 * @return
	 */
	public long getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(long seller_id) {
		this.seller_id = seller_id;
	}
	/**
	 * 30天销量
	 * @return
	 */
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
	
	public String getDateEntered() {
		return dateEntered;
	}
	public void setDateEntered(String dateEntered) {
		this.dateEntered = dateEntered;
	}
	public static void main(String[] args) {
		TbkItem tbkItem = new TbkItem();
		tbkItem.addItemStatus(ItemStatus.NORMAL);
		tbkItem.setNum_iid(12345123);
		tbkItem.setTitle("");
		tbkItem.setPict_url("");
		tbkItem.setSmall_images_string("");
		tbkItem.setReserve_price("");
		tbkItem.setZk_final_price("");
		tbkItem.setProvcity("");
		tbkItem.setItem_url("");
		tbkItem.setNick("");
		tbkItem.save();
		
		tbkItem.isInThisItemStatus(ItemStatus.IS_TBKITEM_CHANGE_TO_NORMAL_ITEM);
	}
	
	
	public String changeSmallImagesToString(SmallImages small_images) {
		if (small_images == null) {
			return "";
		}
		return Tools.join(small_images.getString(), "~,,~");
	}
	public SmallImages changeStringToSmallImages(String small_images_string) {
		String[] urls = small_images_string.split("~,,~");
		List<String> list = new ArrayList<String>();
		if (urls.length > 0 && !"".equals(urls[0])) {
			list = Arrays.asList(urls);
		}
		SmallImages si = new SmallImages();
		si.setString(list);
		return si;
	}
	
	@Override
	public boolean save() {
		this.small_images_string = this.changeSmallImagesToString(this.small_images);
		this.dateEntered = new SimpleDateFormat(Tools.EnumString.TABLE_TIME_FORMAT.getStr()).format(new Date());
		return super.save();
	}
	
	/**
	 * return this.isInThisItemStatus(ItemStatus.IS_TBKITEM_CHANGE_TO_NORMAL_ITEM)
	 * @return
	 */
	public boolean isChangeToItem() {
		return this.isInThisItemStatus(ItemStatus.IS_TBKITEM_CHANGE_TO_NORMAL_ITEM);
	}
	
//	/**
//	 * 生成对应的表单编辑模型
//	 * @return
//	 */
//	public FormComponents getFormComponents() {
//		String urlSubmit = UrlRoute.TBK_ITEMS_SUBMIT.getUrl();
//		String urlRemove = "";
//		FormComponents formComponents = new FormComponents(urlSubmit, urlRemove);
//		List<FormComponents.Component> components = new ArrayList<FormComponents.Component>();
//		
//		Field[] fields = this.getClass().getDeclaredFields();
//		for (Field field : fields) {
//			
//			FormComponentAnno formComponentAnno = field.getAnnotation(FormComponentAnno.class);
//			String desc = "";
//			FormComponents.ComponentType componentType = FormComponents.ComponentType.TEXT;
//			boolean isHidden = false;
//			boolean isDisabled = false;
//			boolean isDiscard = false;
//			if (formComponentAnno != null) {
//				desc = formComponentAnno.desc();
//				componentType = formComponentAnno.componentType();
//				isHidden = formComponentAnno.isHidden();
//				isDisabled = formComponentAnno.isDisabled();
//				isDiscard = formComponentAnno.isDiscard();
//			}
//			if (isDiscard) {
//				continue;
//			}
//			components.add(formComponents.new Component(field.getName(), Tools.getFieldValue(field, this) + "", desc, isHidden, isDisabled, isDiscard, componentType));
//			
//		}
//		
//		formComponents.setComponents(components);
//		
//		return formComponents;
//	}
	
	
}
