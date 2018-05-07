package GetOffers;

/**
 * Created by asus on 2018/3/25.
 */
public class 二叉树的下一个节点 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if(pNode.right!=null){
                pNode=pNode.right;
                while (pNode.left!=null){
                    pNode=pNode.left;
                }
                return pNode;
            }
            if(pNode.next!=null&&pNode.next.left==pNode) return pNode.next;
            if(pNode.next!=null){
                TreeLinkNode parent=pNode.next;
                while (parent!=null&&parent.left!=pNode){
                    pNode=parent;
                    parent=parent.next;
                }
                return parent==null?null:parent;

            }
        return null;
    }


}
