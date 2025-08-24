:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_add_DC_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(3,Self_dimensionSizes,Var_482082765),
nth1(2,Self_dimensionSizes,Var_1754894440),
nth1(1,Self_dimensionSizes,Var_1998767043),
(((Var_1998767043 #> 0) , (Var_1754894440 #> 0)) , (Var_482082765 #> 0)),
nth1(3,Arg_dimensionSizes,Var_1932831450),
nth1(3,Self_dimensionSizes,Var_496729294),
nth1(2,Arg_dimensionSizes,Var_1302227152),
nth1(2,Self_dimensionSizes,Var_1122606666),
nth1(1,Arg_dimensionSizes,Var_350068407),
nth1(1,Self_dimensionSizes,Var_1390869998),
length(Arg_dimensionSizes,Var_1820383114),
length(Self_dimensionSizes,Var_1645547422),
nth1(3,Arg_dimensionSizes,Var_440737101),
nth1(3,Self_dimensionSizes,Var_2141817446),
nth1(2,Arg_dimensionSizes,Var_369049246),
nth1(2,Self_dimensionSizes,Var_1608297024),
nth1(1,Arg_dimensionSizes,Var_1841396611),
nth1(1,Self_dimensionSizes,Var_1577592551),
length(Arg_dimensionSizes,Var_854587510),
length(Self_dimensionSizes,Var_148626113),
nth1(3,Arg_dimensionSizes,Var_1847637306),
nth1(3,Self_dimensionSizes,Var_1904253191),
nth1(2,Arg_dimensionSizes,Var_1021436681),
nth1(2,Self_dimensionSizes,Var_1790585734),
nth1(1,Arg_dimensionSizes,Var_22600334),
nth1(1,Self_dimensionSizes,Var_1961173763),
length(Arg_dimensionSizes,Var_1202683709),
length(Self_dimensionSizes,Var_2087885397),
nth1(3,Arg_dimensionSizes,Var_1002021887),
nth1(3,Self_dimensionSizes,Var_1712943792),
nth1(2,Arg_dimensionSizes,Var_1525919705),
nth1(2,Self_dimensionSizes,Var_842741472),
nth1(1,Arg_dimensionSizes,Var_1156304131),
nth1(1,Self_dimensionSizes,Var_1766505436),
length(Arg_dimensionSizes,Var_771775563),
length(Self_dimensionSizes,Var_1164440413),
(((((((Var_1164440413 #\= Var_771775563) , (Var_1766505436 #= Var_1156304131)) , (Var_842741472 #= Var_1525919705)) , (Var_1712943792 #= Var_1002021887)) ; ((((Var_2087885397 #= Var_1202683709) , (Var_1961173763 #\= Var_22600334)) , (Var_1790585734 #= Var_1021436681)) , (Var_1904253191 #= Var_1847637306))) ; ((((Var_148626113 #= Var_854587510) , (Var_1577592551 #= Var_1841396611)) , (Var_1608297024 #\= Var_369049246)) , (Var_2141817446 #= Var_440737101))) ; ((((Var_1645547422 #= Var_1820383114) , (Var_1390869998 #= Var_350068407)) , (Var_1122606666 #= Var_1302227152)) , (Var_496729294 #\= Var_1932831450))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
