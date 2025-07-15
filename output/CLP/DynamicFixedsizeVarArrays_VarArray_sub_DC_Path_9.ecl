:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

dynamicFixedsizeVarArrays_VarArray_sub_DC_Path_9(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [Result_dim],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_667821226),
nth1(1,Self_dimensionSizes,Var_1998767043),
((Var_1998767043 #> 0),
(Var_667821226 #< 10)),
nth1(1,Self_dimensionSizes,Var_496729294),
nth1(1,Arg_dimensionSizes,Var_1302227152),
length(Self_dimensionSizes,Var_1122606666),
length(Arg_dimensionSizes,Var_350068407),
((Var_350068407 #= Var_1122606666),
(Var_1302227152 #= Var_496729294)),
nth1(1,Result_dimensionSizes,Var_1390869998),
nth1(1,Self_dimensionSizes,Var_1820383114),
length(Result_dimensionSizes,Var_1645547422),
length(Self_dimensionSizes,Var_440737101),
((Var_440737101 #= Var_1645547422),
(Var_1820383114 #= Var_1390869998)),
nth1(1,Arg_dimensionSizes,Var_2141817446),
(Dim1 = Var_2141817446),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_369049246),nth1(Idx0,List_369049246,Var_369049246),(It = Var_369049246),
getArrayElement(Arg_data,[It],Var_1608297024_1),getArrayElement(Self_data,[It],Var_1841396611_1),getArrayElement(Result_data,[It],Var_1577592551_1),(Var_1577592551_1 #= (Var_1841396611_1-Var_1608297024_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_369049246),nth1(Idx0_1,List_369049246,Var_369049246_1),(It_1 = Var_369049246_1),
getArrayElement(Arg_data,[It_1],Var_1608297024_2),getArrayElement(Self_data,[It_1],Var_1841396611_2),getArrayElement(Result_data,[It_1],Var_1577592551_2),(Var_1577592551_2 #= (Var_1841396611_2-Var_1608297024_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_369049246),nth1(Idx0_2,List_369049246,Var_369049246_2),(It_2 = Var_369049246_2),
getArrayElement(Arg_data,[It_2],Var_1608297024_3),getArrayElement(Self_data,[It_2],Var_1841396611_3),getArrayElement(Result_data,[It_2],Var_1577592551_3),(Var_1577592551_3 #= (Var_1841396611_3-Var_1608297024_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_369049246),nth1(Idx0_3,List_369049246,Var_369049246_3),(It_3 = Var_369049246_3),
getArrayElement(Arg_data,[It_3],Var_1608297024_4),getArrayElement(Self_data,[It_3],Var_1841396611_4),getArrayElement(Result_data,[It_3],Var_1577592551_4),(Var_1577592551_4 #= (Var_1841396611_4-Var_1608297024_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_369049246),nth1(Idx0_4,List_369049246,Var_369049246_4),(It_4 = Var_369049246_4),
getArrayElement(Arg_data,[It_4],Var_1608297024_5),getArrayElement(Self_data,[It_4],Var_1841396611_5),getArrayElement(Result_data,[It_4],Var_1577592551_5),(Var_1577592551_5 #= (Var_1841396611_5-Var_1608297024_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_369049246),nth1(Idx0_5,List_369049246,Var_369049246_5),(It_5 = Var_369049246_5),
getArrayElement(Arg_data,[It_5],Var_1608297024_6),getArrayElement(Self_data,[It_5],Var_1841396611_6),getArrayElement(Result_data,[It_5],Var_1577592551_6),(Var_1577592551_6 #= (Var_1841396611_6-Var_1608297024_6)),
(Idx0_6 #= (Idx0_5+1)),
(Idx0_6 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_369049246),nth1(Idx0_6,List_369049246,Var_369049246_6),(It_6 = Var_369049246_6),
getArrayElement(Arg_data,[It_6],Var_1608297024_7),getArrayElement(Self_data,[It_6],Var_1841396611_7),getArrayElement(Result_data,[It_6],Var_1577592551_7),(Var_1577592551_7 #= (Var_1841396611_7-Var_1608297024_7)),
(Idx0_7 #= (Idx0_6+1)),
(Idx0_7 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
