package bitcrack.rustycraft;

public class Reference {
	
	public static final String MOD_ID = "rustcrmod";
	public static final String NAME = "Rustycraft";
	public static final String VERSION = "1.0";
	public static final String ACCEPTED_VERSIONS = "[1.10.2]";
	
	public static final String CLIENT_PROXY_CLASS = "bitcrack.rustycraft.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "bitcrack.rustycraft.proxy.ServerProxy";

	public static enum RustycraftItems
	{
		LANTERN("lantern", "ItemLantern"),
		SCRAP("scrap", "ItemScrap");
		
		private String unlocalizedName;
		private String registryName;
		
		RustycraftItems(String unlocalizedName, String registryName)
		{
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		
		public String getRegistryName() {
			return registryName;
		}
	}
	
	public static enum RustycraftBlocks
	{
		LANTERN("lantern", "BlockLantern"),
		
		BARRELVAR1("barrelvar1", "BlockBarrelvar1"),
		BARRELVAR2("barrelvar2", "BlockBarrelvar2"),
		
		ROCKVAR1_CENTER("rockvar1_center", "BlockRockvar1_center"),
		ROCKVAR1_SIDE("rockvar1_side", "BlockRockvar1_side"),
		ROCKVAR1_CORNER("rockvar1_corner", "BlockRockvar1_corner"),

		ROCKVAR2_CENTER("rockvar2_center", "BlockRockvar2_center"),
		ROCKVAR2_SIDE("rockvar2_side", "BlockRockvar2_side"),
		ROCKVAR2_CORNER("rockvar2_corner", "BlockRockvar2_corner"),

		ROCKVAR3_CENTER("rockvar3_center", "BlockRockvar3_center"),
		ROCKVAR3_SIDE("rockvar3_side", "BlockRockvar3_side"),
		ROCKVAR3_CORNER("rockvar3_corner", "BlockRockvar3_corner");
		
		private String unlocalizedName;
		private String registryName;
		
		RustycraftBlocks(String unlocalizedName, String registryName)
		{
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		
		public String getRegistryName() {
			return registryName;
		}
	}
}
