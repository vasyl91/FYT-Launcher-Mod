package org.apache.poi.poifs.dev;

import java.io.FileInputStream;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.Property;
import org.apache.poi.poifs.property.PropertyTable;
import org.apache.poi.poifs.storage.BlockAllocationTableReader;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.poifs.storage.ListManagedBlock;
import org.apache.poi.poifs.storage.RawDataBlockList;
import org.apache.poi.poifs.storage.SmallBlockTableReader;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IntList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class POIFSHeaderDumper {
    public static void main(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            System.err.println("Must specify at least one file to view");
            System.exit(1);
        }
        for (String str : strArr) {
            viewFile(str);
        }
    }

    public static void viewFile(String str) throws Exception {
        System.out.println("Dumping headers from: " + str);
        FileInputStream fileInputStream = new FileInputStream(str);
        HeaderBlock headerBlock = new HeaderBlock(fileInputStream);
        displayHeader(headerBlock);
        POIFSBigBlockSize bigBlockSize = headerBlock.getBigBlockSize();
        RawDataBlockList rawDataBlockList = new RawDataBlockList(fileInputStream, bigBlockSize);
        displayRawBlocksSummary(rawDataBlockList);
        displayBATReader("Big Blocks", new BlockAllocationTableReader(headerBlock.getBigBlockSize(), headerBlock.getBATCount(), headerBlock.getBATArray(), headerBlock.getXBATCount(), headerBlock.getXBATIndex(), rawDataBlockList));
        PropertyTable propertyTable = new PropertyTable(headerBlock, rawDataBlockList);
        displayBATReader("Small Blocks", SmallBlockTableReader._getSmallDocumentBlockReader(bigBlockSize, rawDataBlockList, propertyTable.getRoot(), headerBlock.getSBATStart()));
        displayPropertiesSummary(propertyTable);
    }

    public static void displayHeader(HeaderBlock headerBlock) throws Exception {
        System.out.println("Header Details:");
        System.out.println(" Block size: " + headerBlock.getBigBlockSize().getBigBlockSize());
        System.out.println(" BAT (FAT) header blocks: " + headerBlock.getBATArray().length);
        System.out.println(" BAT (FAT) block count: " + headerBlock.getBATCount());
        if (headerBlock.getBATCount() > 0) {
            System.out.println(" BAT (FAT) block 1 at: " + headerBlock.getBATArray()[0]);
        }
        System.out.println(" XBAT (FAT) block count: " + headerBlock.getXBATCount());
        System.out.println(" XBAT (FAT) block 1 at: " + headerBlock.getXBATIndex());
        System.out.println(" SBAT (MiniFAT) block count: " + headerBlock.getSBATCount());
        System.out.println(" SBAT (MiniFAT) block 1 at: " + headerBlock.getSBATStart());
        System.out.println(" Property table at: " + headerBlock.getPropertyStart());
        System.out.println("");
    }

    public static void displayRawBlocksSummary(RawDataBlockList rawDataBlockList) throws Exception {
        System.out.println("Raw Blocks Details:");
        System.out.println(" Number of blocks: " + rawDataBlockList.blockCount());
        for (int i = 0; i < Math.min(16, rawDataBlockList.blockCount()); i++) {
            ListManagedBlock listManagedBlock = rawDataBlockList.get(i);
            int iMin = Math.min(48, listManagedBlock.getData().length);
            byte[] bArr = new byte[iMin];
            System.arraycopy(listManagedBlock.getData(), 0, bArr, 0, iMin);
            System.out.println(" Block #" + i + ":");
            System.out.println(HexDump.dump(bArr, 0L, 0));
        }
        System.out.println("");
    }

    public static void displayBATReader(String str, BlockAllocationTableReader blockAllocationTableReader) throws Exception {
        System.out.println("Sectors, as referenced from the " + str + " FAT:");
        IntList entries = blockAllocationTableReader.getEntries();
        for (int i = 0; i < entries.size(); i++) {
            int i2 = entries.get(i);
            String string = Integer.toString(i2);
            if (i2 == -2) {
                string = "End Of Chain";
            } else if (i2 == -4) {
                string = "DI Fat Block";
            } else if (i2 == -3) {
                string = "Normal Fat Block";
            } else if (i2 == -1) {
                string = "Block Not Used (Free)";
            }
            System.out.println("  Block  # " + i + " -> " + string);
        }
        System.out.println("");
    }

    public static void displayPropertiesSummary(PropertyTable propertyTable) {
        System.out.println("Mini Stream starts at " + propertyTable.getRoot().getStartBlock());
        System.out.println("Mini Stream length is " + propertyTable.getRoot().getSize());
        System.out.println();
        System.out.println("Properties and their block start:");
        displayProperties(propertyTable.getRoot(), "");
        System.out.println("");
    }

    public static void displayProperties(DirectoryProperty directoryProperty, String str) {
        String str2 = str + "  ";
        System.out.println(str + "-> " + directoryProperty.getName());
        for (Property property : directoryProperty) {
            if (property instanceof DirectoryProperty) {
                displayProperties((DirectoryProperty) property, str2);
            } else {
                System.out.println(str2 + "=> " + property.getName());
                System.out.print(str2 + "   " + property.getSize() + " bytes in ");
                if (property.shouldUseSmallBlocks()) {
                    System.out.print("mini");
                } else {
                    System.out.print("main");
                }
                System.out.println(" stream, starts at " + property.getStartBlock());
            }
        }
    }
}
